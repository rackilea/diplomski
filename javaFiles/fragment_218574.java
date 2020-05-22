import  org.apache.hadoop.conf.Configuration;
import javax.ws.rs.Path;

@Path("/oozie")
public class RestServiceOozie {

  @GET
  @org.apache.hadoop.fs.Path("/{param}/{param2}/{param3}/{param4}")
  public void fooMethod() {
    String arguments = "hdfs://nameservice1/user/ec2-user/" + bedroom + "-" + bathroom + "-" + area + "-" + city;
    Configuration configuration = new Configuration();
    FileSystem fileSystem = FileSystem.get(configuration);
    org.apache.hadoop.fs.Path path = new org.apache.hadoop.fs.Path(arguments); // getting error on this path
    if (!fileSystem.exists((org.apache.hadoop.fs.Path)path)) {
      System.out.println("File does not exists");
    }
  }
}