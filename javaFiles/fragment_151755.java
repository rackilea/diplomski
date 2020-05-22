public static void main(String[] args) throws Exception {
    JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showOpenDialog(null);
    if (option == JFileChooser.APPROVE_OPTION) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Files.copy(Paths.get(fileChooser.getSelectedFile().toURI()), out);
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        String base64Str = encoder.encode(out.toByteArray());
        System.out.println(base64Str);
    }
}