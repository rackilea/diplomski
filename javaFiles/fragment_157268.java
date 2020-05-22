public static void main(String args[]) { 
    A a=new A(); 
    try {
        a.add(); 
    } catch (IOException e) {
        // Don't really know how you want to handle it, so I'll just print a line on System.err.
        System.err.println("add() failed!");
    } 
}