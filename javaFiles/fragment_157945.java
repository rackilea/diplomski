public static void main(String[] args) 
{
    //Create a file object.
    File productFile = new File("product.txt");

    //Open a buffered output stream to allow write to file operations.
    PrintWriter out = null;
    try {   
        out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(productFile)));      

        out.println("java\tMurach's Beginning Java 2\t$49.99");
    }
    catch(IOException ex) {
        // todo exception handling

        System.out.println("ERROR! " + ex);

    }
    finally {
        out.close();

    }

    BufferedReader in = null;
    try {
        in = new BufferedReader(
                new FileReader(productFile));

        String line = in.readLine();
        System.out.println(line);
    }
    catch (IOException ex) {
        // todo more exception handling
        System.out.println("ERROR! " + ex);
    }
    finally {
        in.close();
    }

}