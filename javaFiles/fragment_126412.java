public class SomeCommand extends CommandBase {

    @Override //This is a required override
    public String getName() {
        return "some";
    }

    @Override //This is an optional override, method was not abstract
    public String getUsage() {
        return super.getUsage() + " <text>"; //refer to superclass for original method invocation
        //Would return '/some <text>'
    }