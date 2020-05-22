public class Main {

    public static void main(String[] args) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(args[0]);
        SecretKeySpec key = new SecretKeySpec(bytes, "AES");
        ClassLoader loader = new EncryptedClassLoader(key);
        Class<?> cls = loader.loadClass("com.stackoverflow.example.SecureMain");
        Runnable main = (Runnable) cls.newInstance();
        main.run();
    }

}