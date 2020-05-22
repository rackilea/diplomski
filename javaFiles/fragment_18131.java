public class Test {
public static void main(String[] args) throws UnknownHostException {
    DeveloperDAO developerDAO = new DeveloperDAO("test");
    for(Developer developer : developerDAO.find().asList())
        System.out.println(developer.getFoo());
}}