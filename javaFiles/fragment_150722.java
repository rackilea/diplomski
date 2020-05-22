public class SecureClassLoader extends URLClassLoader {

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        if (isEncrypted(name)) {
            final String resourceName = name.replace('.', '/') + ".class";
            URL url = findResource(resourceName);
            if (url != null) {
                byte[] classBytes = null;
                try {
                    classBytes = EncryptionUtil.decryptBytes(url, key);
                    return defineClass(name, classBytes, 0, classBytes.length);
                } catch (ClassFormatError e) {
                    log.severe("Bad format for decrypted class " + name);
                    throw new EncryptedClassNotFoundException(name, e);
                } catch (InvalidKeyException e) {
                    throw new EncryptedClassNotFoundException(name, e);
                } catch (IOException e) {
                    throw new EncryptedClassNotFoundException(name, e);
                }
            }
        }

        // default loader
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
            throw new EncryptedClassNotFoundException(name, e);
        }
    }

    private boolean isEncrypted(String className) {
        /// some things
    }
}