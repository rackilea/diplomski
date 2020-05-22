public class Configuration {
    public Configuration() {}

    public String[] getparams() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileStream = new FileInputStream("C:/.../Desktop/configuration.txt");
        try {
            properties.load(fileStream);
            String ip = (String) properties.get("IP");
            String port = (String) properties.get("Port");
            return new String[]{ip, port};

        } finally {
            try {
                fileStream.close();
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}