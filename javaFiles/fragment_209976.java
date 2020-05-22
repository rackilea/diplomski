public class EntryPoint
{
    static
    {
        // Workaround for entry points being static initializers
        String[] arguments = getArgumentsHoweverThatHappens();
        RealEntryPoint.execute(arguments);
    }
}