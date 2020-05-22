public class OSValidator {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows(){
        return (OS.indexOf("win")>=0);
    }

    public static boolean isMac(){
        return (OS.indexOf("mac")>=0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >=0 || OS.indexOf("nux") >=0 || OS.indexOf("aix") >= 0);
    }

    public static boolean isSolaris(){
        return (OS.indexOf("sunos") >=0);
    }
}



if (OSValidator.isWindows()) {
            System.out.println("This is Windows");
            file = new File(System.getenv("APPDATA") + File.separator + "TargetApp" + File.separator +"config.json");

            if (!file.exists()) {
                try {
                    FileUtils.forceMkdir(file.getParentFile());
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (OSValidator.isMac()) {
            System.out.println("This is Mac");

            file = new File(System.getProperty("user.home") + File.separator + "Library" + File.separator + "Application Support"
                    + File.separator + "config.json");
        }