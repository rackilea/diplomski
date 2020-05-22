class HumidityPacket implements Packet {}

public class Main {
    public static void main(String[] args) {
        MainParser parser = new MainParser();
        //...
        parser.registerPacketListener(new PacketListener<HumidityPacket>() {
            @Override
            public Class<HumidityPacket> getPacketClass() {
                return HumidityPacket.class;
            }

            @Override
            public void onPacket(HumidityPacket packet) {
                // todo 
            }
        });
    }
}