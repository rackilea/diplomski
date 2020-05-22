public class EncryptedClassLoader extends ClassLoader {

    private final SecretKeySpec key;

    public EncryptedClassLoader(SecretKeySpec key) {
        this.key = key;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String[] segments = name.split("\\.");
            String filePath = String.join("/", segments) + ".enc";
            byte[] bytes = decryptResource(filePath);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            throw new ClassNotFoundException("Unable to load class: " + name, e);
        }
    }

    private byte[] decryptResource(String filePath) throws Exception {
        File file = new File(getResource(filePath).getFile());
        byte[] bytes = Files.readAllBytes(file.toPath());
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(bytes);
    }

}