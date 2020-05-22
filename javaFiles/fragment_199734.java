/* Download apache common-io.xxx. jar*/

    public class CodecHandler {
        Base64 codec = null;

        public CodecHandler() {
            codec = new Base64();
        }

        public byte[] encode(byte[] decoded) {
            return codec.encode(decoded);
        }

        public byte[] decode(byte[] encoded) {
            return codec.decode(encoded);
        }

        public static void main(String[] args) throws IOException {
            File file = new File("D:/Test.mp4");
            byte[] fileByteArray = FileUtils.readFileToByteArray(file);
            CodecHandler codecHandler = new CodecHandler();
            byte[] encoded = codecHandler.encode(fileByteArray);
            System.out.println("Byte Size : " + encoded.length);
            byte[] decode = codecHandler.decode(encoded);
            FileUtils.writeByteArrayToFile(new File("C:/Test.mp4"), decode);


        }
    }