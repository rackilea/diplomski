public class ParseISOMessage {

    private static org.jpos.iso.packager.ISO87APackager packager = new org.jpos.iso.packager.ISO87APackager();

    public static void main(String[] args) throws IOException, ISOException, DecoderException {
        String data = createMSG();
        // Create ISO Message
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        final byte[] bytes = new Hex().decode(data.getBytes());
        isoMsg.unpack(bytes);
    ...
    private static String createMSG() {
        try {
//            ISO87BPackager packager = new ISO87BPackager(); // delete this line otherwise it cannot unpack
            ISOMsg isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.setMTI("0200");
           ...//same
            isoMsg.set(64, "ABCDEF0123456789");
            byte[] b = isoMsg.pack();
            System.out.println("**" + new String(Hex.encodeHex(b, false)) + "**"); // make the result uppercase.
            return Hex.encodeHexString(b);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}