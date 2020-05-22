public static void main(String args[]) throws IOException { 
    try (PrintStream ps = new PrintStream(new FileOutputStream("myfile.txt"))) {
        ps.println("This data is written to a file:");
        System.out.println("Write successfully");
    } catch (IOException e) {
        System.err.println("Error in writing to file");
        throw e;
    }
}