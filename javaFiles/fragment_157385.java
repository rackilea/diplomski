public final class ClassFileVersion {

    private final int major;
    private final int minor;

    private ClassFileVersion(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public static ClassFileVersion of(Class<?> classFile) throws IOException {
        try (InputStream is = classFile.getResourceAsStream("/%s.class".formatted(classFile.getName().replace('.', '/')))) {
            var buffer = new byte[8];
            if (is.read(buffer) != buffer.length) {
                throw new AssertionError("Not a Java Class File!");
            }
            return new ClassFileVersion(readUnsignedShort(buffer, 6), readUnsignedShort(buffer, 4));
        }
    }

    public String getVersionNumber() {
        return "%d.%d".formatted(major, minor);
    }

    public boolean isEnablePreview() {
        return major >= 55 && minor == 0xFFFF;
    }

    @Override
    public String toString() {
        return (major < 49 ? "JDK " : "Java SE ") +
            switch(major) {
                case 45 -> "1.1";
                case 46 -> "1.2";
                case 47 -> "1.3";
                case 48 -> "1.4";
                case 49 -> "5";
                case 50 -> "6";
                case 51 -> "7";
                case 52 -> "8";
                case 53 -> "9";
                case 54 -> "10";
                case 55 -> "11";
                case 56 -> "12";
                case 57 -> "13";
                case 58 -> "14";
                default -> throw wrongVersion();
            } +
            switch(minor) {
                case 0 -> "";
                case 3 -> {
                    if (major != 45) {
                        throw wrongVersion();
                    }
                    yield "";
                }
                case 0xFFFF -> " --enable-preview";
                default -> throw wrongVersion();
            };
    }

    private static int readUnsignedShort(byte[] buffer, int offset) {
        return ((buffer[offset] & 0xff) << 8) + (buffer[++offset] & 0xff);
    }

    private AssertionError wrongVersion() {
        return new AssertionError("Wrong Java Class File Version: %d.%d".formatted(major, minor));
    }
    // to run this code (JDK 13 needed):
    // java --enable-preview --source 13 ClassFileVersion.java 
    public static void main(String[] args) throws IOException {
        // prints "Java SE 13 --enable-preview"
        System.out.println(ClassFileVersion.of(ClassFileVersion.class));
    }

}