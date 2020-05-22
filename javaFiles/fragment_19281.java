private static void terminateProgram()
{
    terminate = true; // if this method simply is to terminate a program
                      // I'm not quite sure why you need a `terminate` variable
                      // unless you're using it in another part of the program.
                      // A simple system.exit(0) would suffice.
    System.exit(0);
}