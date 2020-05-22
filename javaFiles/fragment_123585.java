public static void main(String[] args) throws FileNotFoundException {
    int one = 1514;
    int zero = 396;
    PrintWriter out = new PrintWriter("output.txt"); //create PrintWriter
    for (int i = 0; i <= one; i++) {
        out.println("1"); //Write "1"
    }
    for (int x = 0; x <= zero; x++) {
        out.println("0"); //Write "0"
    }  
    out.close(); //close PrintWriter    

}