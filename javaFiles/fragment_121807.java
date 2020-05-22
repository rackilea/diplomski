public class JettyWebApp {

    public static void main(String[] args) throws Exception {

        Server server = new Server();

        if (args == null) {
            System.err.println(errorMessage + ": args == null");
            throw new RuntimeException(errorMessage);
        }
        String jsonFile = "";
        for (String arg : args) {
            System.err.println(arg);
            if (StringUtils.contains(arg, ".json")) {
                jsonFile = arg;
                break;
            }
        }
    ...
}