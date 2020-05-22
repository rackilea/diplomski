public class exportDataBase {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        exportDatabase("", "Sma_test.sql", "C:", 0);

    }

    public static boolean exportDatabase(String fromServer, String FileName,
            String FilePath, int ExportOpions) {
        try {

            String dbName = "dmsdev";
            String dbUser = "root";
            String dbPass = "root";

            String dumbPath = "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\";

            String executeCmd = "/" + dumbPath + "mysqldump -u " + dbUser
                    + " -p" + dbPass + " " + dbName + " -r " + FilePath + "\\"
                    + FileName;

            System.out.println(executeCmd);
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            System.out.println("processComplete: " + processComplete);

            if (processComplete == 1) {// if values equal 1 process failed
                System.out.println("Backup failed");
            }

            else if (processComplete == 0) {
                System.out.println("Backup Success");

            }
            return true;
        } catch (final Exception ex) {
            System.out.println("Connection failed");
            return false;
        }
    }

}