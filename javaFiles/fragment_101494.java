import javax.mail.internet.InternetAddress;

/**
Display package name and version information for javax.mail.internet.
*/
public final class ReadVersion {
  public static void main(String... aArgs){
    ReadVersion readVersion = new ReadVersion();
    readVersion.readVersionInfoInManifest();
  }

  public void readVersionInfoInManifest(){
    InternetAddress object = new InternetAddress();
    Package objPackage = object.getClass().getPackage();
    //examine the package object 
    String name = objPackage.getSpecificationTitle();
    String version = objPackage.getSpecificationVersion();
    //some jars may use 'Implementation Version' entries in the manifest instead
    System.out.println("Package name: " + name);
    System.out.println("Package version: " + version);
  }
}