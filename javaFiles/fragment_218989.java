public static void main(String args[]) {
    try {
        InputStreamReader instream = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader(instream);
        char c = (char) stdin.read();
    } catch (IOException ex) {
        // handle error in some way
        ex.printStackTrace(); 
    }
}