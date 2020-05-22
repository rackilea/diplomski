public class JavaApplication1 {
    final private static String osName = System.getProperty("os.name");
    static final Properties configFile = new Properties();

    static {
        try {
            configFile.load(new FileInputStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    private static String DIR = osName.equals("Linux") ? configFile.getProperty("tempDirForLinux") : configFile.getProperty("tempDirForWindows");

    public static void main(String[] args) throws IOException {
        System.out.println(DIR);
    }
}