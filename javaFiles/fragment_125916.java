public class RunManager {

    private String jarPath;
    private String osName;
    private String architecture;

    public RunManager() {

    }

    public RunManager(String[] args) {
        this.jarPath = args[0];
        this.osName = args[1];
        this.architecture = args[2];
    }

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }       
}