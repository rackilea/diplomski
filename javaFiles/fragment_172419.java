public static void main(String[] args)
{
    boolean quit = false;

    String serverPolicyPath = "/Policies/Server.policy";
    URL serverPolicyURL = Main.class.getResource(serverPolicyPath);

    if (serverPolicyURL == null)
    {
        System.err.println("getResource returned NULL");
        return;
    }

    System.setProperty("java.security.policy",serverPolicyURL.toString());
    Policy.getPolicy().refresh();

    ...