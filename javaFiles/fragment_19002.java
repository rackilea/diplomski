public class ByteListSerializer {
static private final int INT_SIZE = Integer.SIZE / 8;

    static public void main(String...args) {
        ByteListSerializer bls = new ByteListSerializer();

        // ============== variable declaration =================
        String dataA = "hello";
        String dataB = "world";
        List<byte[]> info = new ArrayList<byte[]>();
        info.add(new byte[] {'s','o','m','e'});
        info.add(new byte[] {'d','a','t','a'});
        // ============= end variable declaration ==============

        // ======== serialization =========
        info.add(0, dataA.getBytes());
        info.add(1, dataB.getBytes());
        byte[] result = bls.dataSerializer(info);

        System.out.println(Arrays.toString(result));

        // ======== deserialization ========
        List<byte[]> back = bls.dataDeserializer(result);

        String backDataA = new String(back.get(0));
        String backDataB = new String(back.get(1));
        back.remove(0);
        back.remove(0);

        // ============ print end result ============
        System.out.println(backDataA);
        System.out.println(backDataB);
        for (byte[] b : back) {
            System.out.println(new String(b));
        }
    }

    public byte[] dataSerializer(List<byte[]> data) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteBuffer lenBuffer = ByteBuffer.allocate(4);

        try {
            for (byte[] d : data) {
                lenBuffer.putInt(0, d.length);
                out.write(lenBuffer.array());
                out.write(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // wrap this
        byte[] dataBuffer = new byte[out.size() + 4];
        lenBuffer.putInt(0, out.size());
        System.arraycopy(lenBuffer.array(), 0, dataBuffer, 0, 4);
        System.arraycopy(out.toByteArray(), 0, dataBuffer, 4, out.size());

        return dataBuffer;
    }

    public List<byte[]> dataDeserializer(byte[] data) {
        if (data.length < INT_SIZE) {
            throw new IllegalArgumentException("incomplete data");
        }

        ByteBuffer dataBuffer = ByteBuffer.wrap(data);
        int packetSize = dataBuffer.getInt();

        if (packetSize > data.length - INT_SIZE) {
            throw new IllegalArgumentException("incomplete data");
        }

        List<byte[]> dataList = new ArrayList<byte[]>();
        int len, pos = dataBuffer.position(), nextPos;

        while (dataBuffer.hasRemaining() && (packetSize > 0)) {
            len = dataBuffer.getInt();
            pos += INT_SIZE;
            nextPos = pos + len;
            dataList.add(Arrays.copyOfRange(data, pos, nextPos));

            dataBuffer.position(pos = nextPos);
            packetSize -= len;
        }

        return dataList;
    }
}