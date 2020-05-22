public class WritePGM {
    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            // Format P5/binary gray
            out.write("P5\n".getBytes(StandardCharsets.UTF_8));
            // Dimensions (width/height)
            out.write(String.format("%s 1\n", size).getBytes(StandardCharsets.UTF_8));
            // MaxSample
            out.write("255\n".getBytes(StandardCharsets.UTF_8));

            // Just write a single line of 0-bytes
            for (int i = 0; i < size; i++) {
                out.write(0);
            }
        }
    }
}