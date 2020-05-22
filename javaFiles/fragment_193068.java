public class ImageLoader {
    private static final int START_IMAGE_ID = 1;
    private static final int END_IMAGE_ID = 1000;

    private static final String IMAGE_URL = "http://savepic.net/%d.jpg";

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "username", "password");
        PreparedStatement imageStatement = connection.prepareStatement("INSERT INTO public.image VALUES(?, ?)");

        for (int i = START_IMAGE_ID; i <= END_IMAGE_ID; i++) {
            String imageUrl = String.format(IMAGE_URL, i);

            URL url = new URL(imageUrl);
            URLConnection urlConnection = url.openConnection();

            imageStatement.setLong(1, i);
            imageStatement.setBytes(2, read(urlConnection.getInputStream()));

            int count = imageStatement.executeUpdate();
            if (count != 1) {
                throw new IllegalStateException("Image with ID = " + i + " not inserted");
            } else {
                System.out.println("Image (" + imageUrl + ") saved to database");
            }
        }

        imageStatement.close();
        connection.close();
    }

    private static byte[] read(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1 << 15); // assume image average size ~ 32 Kbytes
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        byte[] buffer = new byte[1 << 10];

        int read = -1;
        while ((read = bufferedInputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, read);
        }

        return byteArrayOutputStream.toByteArray();
    }
}