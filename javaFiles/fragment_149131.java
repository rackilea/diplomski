public class PacketHandler implements PacketProcessingListener {

    private final static Logger LOG = LoggerFactory.getLogger(PacketHandler.class);
    private final DataBroker dataBroker;
    private final PacketProcessingService packetProcessor;

    public PacketHandler(DataBroker dataBroker, PacketProcessingService packetProcessor) {
        super();
        this.dataBroker = dataBroker;
        this.packetProcessor = packetProcessor;
    }

    @Override
    public void onPacketReceived(PacketReceived notification) {

        LOG.trace("PacketReceived invoked...");
        short tableId = notification.getTableId().getValue();
        byte[] data = notification.getPayload();
        // BigInteger metadata =
        // notification.getMatch().getMetadata().getMetadata();
        Ethernet res = new Ethernet();

        try {
            res.deserialize(data, 0, data.length * NetUtils.NumBitsInAByte);
        } catch (Exception e) {
            LOG.warn("Failed to decode Packet ", e);
            return;
        }
        try {
            Packet pkt = res.getPayload();
            if (pkt instanceof IPv4) {
                IPv4 ipv4 = (IPv4) pkt;
                // Handle IPv4 packet
            }
            return;

        } catch (Exception ex) {
            // Failed to handle packet
            LOG.error("Failed to handle subnetroute packets ", ex);
        }
        return;

    }
}