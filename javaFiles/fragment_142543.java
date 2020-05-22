public class Manager
{
    private ManagerConnection c;

    public Manager() throws Exception
    {
        ManagerConnectionFactory factory = new ManagerConnectionFactory(
                "tttt", "admin", "ttt");
        c =  factory.createManagerConnection();
    }

    public String run() throws Exception
    {
        c.login();

        CommandAction action;
        CommandResponse response;
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        action = new CommandAction();
        action.setCommand(" sip show peers");
        response = (CommandResponse) c.sendAction(action);

        list = response.getResult();
        for (String s : list) {
            if (s.contains("VOIP")) {
            out.print(s);
            sb.append(s);
            }
        }

        c.logoff();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception
    {
        new Manager().run();
    }
}