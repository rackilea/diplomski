public static void main(String... args) {
    try {
       List<String> lines = readFile(args[0]);
       // don't try to display the lines of a file if it failed with an IOException
       display(lines);
    } catch(IOException ioe) {
       System.err.println("Cannot display file " + ioe);
    }
}