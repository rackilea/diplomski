/**
 *
 * @component
 */
private RuntimeInformation runtime;

public void execute() {
     String version = runtime.getMavenVersion();
     getLog().info("Maven Version: " + version);
     ...
}