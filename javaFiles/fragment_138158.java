public static void main(String[] args) {
    int avatarnum = 1;
    BufferedImage image = null;

    String[] extensions = { "jpg", "png", "gif", "bmp" };

    while (avatarnum <= 1000) {
        for (String extension : extensions) {
            try {
                URL url = new URL("http://forum.blockland.us/avatarUpload/avatar_" + avatarnum + "." + extension);
                image = ImageIO.read(url);

                try {
                    ImageIO.write(image, extension, new File("C:\\test\\" + avatarnum + "." + extension));
                    System.out.println("Write successful");

                } catch (Exception e) {
                    System.out.println("Error on save the image");
                }

            } catch (IOException e) {
                System.out.println("File not found! " + avatarnum + "." + extension);

            }
        }
        avatarnum++;
    }
    System.out.println("Done");
}