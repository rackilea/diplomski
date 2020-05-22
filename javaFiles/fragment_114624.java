public class EncryptedArrayOutputStream extends ByteArrayOutputStream {

@Override
public void write(byte[] b) throws IOException{
    byte[] encrypted = encrypt(b);
    super.write(encrypted);

}

private byte[] encrypt(byte[] bytes) {

    byte[] encrypted = new byte[bytes.length]; // This also might not be the size depending on the algorithm you choose
    // Your algorithm here....
    return encrypted;
}
}