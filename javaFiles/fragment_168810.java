public class JenkinsJobCreate {
public static void main(String[] args) {

    System.out.println("JenkinsJobsTrigger has started ###############################");

    String ipAddress = "http://localhost:8080/";
    String jobName = "Hello-world";

    String username = "admin";
    String password = "admin";

    System.out.println("ipAddress: " + ipAddress);
    System.out.println("jobName: " + jobName);

    System.out.println("username: " + username);
    System.out.println("password: " + password);


    try (JenkinsServer jenkinsServer = new JenkinsServer(new URI(ipAddress), username, password)) {

        // our XML file for this example
        File xmlFile = new File("src/main/resources/config.xml");

        // Let's get XML file as String using BufferedReader
        // FileReader uses platform's default character encoding
        // if you need to specify a different encoding, use InputStreamReader
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);

        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null){
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String jobXml = sb.toString();
        System.out.println("XML to String using BufferedReader : ");
        System.out.println(jobXml);

        bufReader.close();

        jenkinsServer.createJob(jobName, jobXml, true);

    } catch (Exception e) {
        System.out.println("Exception Occured!!!");
        e.printStackTrace();
    }

    System.out.println("JenkinsJobsTrigger has Finished ###############################");

}