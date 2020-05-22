public class Calculator implements CommandProvider {

    // add prints sum of its two arguments
    public void _add(CommandInterpreter ci) {
        int a = Integer.parseInt(ci.nextArgument());
        int b = Integer.parseInt(ci.nextArgument());
        ci.println(a+b);
    }

    // quit just calls "exit"
    public void _quit(CommandInterpreter ci) {
        ci.execute("exit");
    }

    @Override
    public String getHelp() {
        return "";
    }

}