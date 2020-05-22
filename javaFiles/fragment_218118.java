public class RunOracleSql {
    public static void main(String[] args) {
        final String fileExtension = ".sql";
        String script_location = "C:/SQLFileLocation";
        try {
            File file = new File("C:/SQLFileLocation");
            File[] listFiles = file.listFiles(new FileFilter() {

                public boolean accept(File f) {
                    if (f.getName().toLowerCase().endsWith(fileExtension))
                        return true;
                    return false;
                }
            });
            for (int i = 0; i < listFiles.length; i++) {
                script_location = "@" + listFiles[i].getAbsolutePath();// ORACLE
                ProcessBuilder processBuilder = new ProcessBuilder("sqlplus",
                        "username/password@database_name", script_location); // ORACLE

                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        process.getInputStream()));
                String currentLine = null;
                while ((currentLine = in.readLine()) != null) {
                    System.out.println(" " + currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}