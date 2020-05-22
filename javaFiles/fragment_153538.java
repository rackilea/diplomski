import java.util.Base64;

...

public static void main(String[] args) throws FileNotFoundException, IOException {
    byte[] bytes = convertDocToByteArray("some.pdf");
    String stream = Base64.getEncoder().encodeToString(bytes);
    byte[] newBytes = Base64.getDecoder().decode(stream);
    convertByteArrayToDoc("some_new.pdf", newBytes);
}