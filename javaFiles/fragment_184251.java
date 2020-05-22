public class AddToCommandLine {
    public static void main(String[] args) 
    { 
        if(args != null && args.length == 2)
        {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println(x+y);
        }
        else
            System.out.println("Wrong number of command line arguments. This program require 2 arguments");
    }
}