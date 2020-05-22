interface Packet {
}
interface PacketParser<T extends Packet> {
    Class<T> getPacketClass();
    int getPacketId();
    int getPacketLength();
    Packet parse(byte[] raw, int offset);
}
interface PacketListener<T extends Packet> {
    Class<T> getPacketClass();
    void onPacket(T packet);
}
interface PacketParsersRegistry {
    <T extends Packet> void registerPacketParser(PacketParser<T> packetParser);
    <T extends Packet> void registerPacketListener(PacketListener<T> packetListener);
}
class PacketHandlers<T extends Packet> {
    final PacketParser<T> parser;
    PacketListener<T> listener;

    PacketHandlers(PacketParser<T> parser) {
        this.parser = parser;
    }

    void setListener(PacketListener<T> listener) {
        this.listener = listener;
    }
}
class MainParser implements PacketParsersRegistry {
    private final HashMap<Class<?>, PacketHandlers<?>> handlers = new HashMap<>();
    private final HashMap<Integer, PacketParser> parsers = new HashMap<>();

    @Override
    public <T extends Packet> void registerPacketParser(PacketParser<T> packetParser) {
        parsers.put(packetParser.getPacketId(), packetParser);

        Class<T> packetClass = packetParser.getPacketClass();
        handlers.put(packetClass, new PacketHandlers<>(packetParser));
    }

    @Override
    public <T extends Packet> void registerPacketListener(PacketListener<T> packetListener) {
        //noinspection unchecked
        PacketHandlers<T> handlers = (PacketHandlers<T>) this.handlers.get(packetListener.getPacketClass());
        if (handlers != null) {
            handlers.setListener(packetListener);
        }
    }

    void parse(byte[] stream, int offset) {
        while (offset < stream.length) {
            int type = stream[offset];
            PacketParser parser = parsers.get(type);
            // parser m.b. != null here
            PacketListener listener = (PacketListener) handlers.get(parser.getPacketClass());
            if (listener != null) {
                Packet packet = parser.parse(stream, offset);
                //noinspection unchecked
                listener.onPacket(packet);
            }
            offset += parser.getPacketLength();
        }
    }
}