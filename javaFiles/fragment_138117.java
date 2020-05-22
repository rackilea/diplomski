public class CmdLineArgs {
    public void printArgs() {
        String[] args = Scratch2.getArgs();
        System.out.println ("Arg count is [" + args.length + "]");
        for (int i = 0; i < args.length; i++) {
            System.out.println ("Arg[" + i + "] is [" + args[i] + "]");
        }
    }
}