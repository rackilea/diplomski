public final class Message implements Closeable {
    // or initialize it from some external source if this might change dynamically
    private static final int MAX_SIZE = 50000;
    // better determine this in sync with addHeader() method
    private static final int HEADER_SIZE = 36;

    private final byte dataCenter;
    private final byte recordVersion;
    private final long address;
    private final long addressFrom;
    private final long addressOrigin;
    private final byte recordsPartition;
    private final byte replicated;
    private final DatabaseDelivery delivery;
    private final ByteBuffer itemBuffer = ByteBuffer.allocate(MAX_SIZE);
    private int pendingItems = 0;

    public Message(final Partition recordPartition, final DatabaseDelivery databaseDelivery) {
        this.recordsPartition = (byte) recordPartition.getPartition();
        this.dataCenter = Utils.CURRENT_LOCATION.get().datacenter();
        this.recordVersion = 1;
        this.replicated = 0;
        final long packedAddress = new Data().packAddress();
        this.address = packedAddress;
        this.addressFrom = 0L;
        this.addressOrigin = packedAddress;
        this.delivery = databaseDelivery;
    }

    private void addHeader(final ByteBuffer buffer, final int items) {
        buffer.put(dataCenter)
              .put(recordVersion)
              .putInt(items)
              .putInt(buffer.capacity())
              .putLong(address)
              .putLong(addressFrom)
              .putLong(addressOrigin)
              .put(recordsPartition)
              .put(replicated);
    }

    private void sendData() {
        if (itemBuffer.position() == 0) {
            // no data to be sent
            //Properties: itemBuffer serialized size == 0
            return;
        }
        final ByteBuffer buffer = ByteBuffer.allocate(MAX_SIZE);
        addHeader(buffer, pendingItems);
        itembuffer.flip();
        buffer.put(itemBuffer);
        delivery.sendToDatabase(address, Arrays.copyOf(buffer.array(),buffer.position());
        itemBuffer.clear();
        pendingItems = 0;
        //Properties: itemBuffer serialized size == 0                
    }

    public void addAndSendJunked(final byte[] key, final byte[] data) {
        if (key.length > 255) {
            return;
        }
        if (data.length > 255) {
            return;
        }
        final byte keyLength = (byte) key.length;
        final byte dataLength = (byte) data.length;

        final int additionalSize = dataLength + keyLength + 1 + 1 + 8 + 2;
        final int newSize = itemBuffer.position() + additionalSize;
        //Properties: itemBuffer serialized size < MAX
        if (newSize >= (MAX_SIZE-HEADER_SIZE)) {
            sendData();
        }
        if (additionalSize > (MAX_SIZE-HEADER_SIZE)) {
            //XXX Use exception that is appropriate for your application
            //XXX You might add sizes involved for ease of analysis
            throw new AppConfigurationException("Size of single item exceeds maximum size");
        }
        //Properties: itemBuffer size (old+new or new) < MAX 

        final ByteBuffer dataBuffer = ByteBuffer.wrap(data);
        final long timestamp = dataLength > 10 ? dataBuffer.getLong(2) : System.currentTimeMillis();
        // data layout
        itemBuffer.put((byte) 0).put(keyLength).put(key).putLong(timestamp).putShort(dataLength).put(data);
        pendingItems++ ;