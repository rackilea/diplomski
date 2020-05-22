...
public static void main(String[] args) {
    // TODO code application logic here
    boolean accepted = false;
    while(!accepted) {
       Scanner sc = new Scanner(System.in);
       ...

       if(!isBinary) {
           System.out.println("this is not a binary number");
       } else {
           accepted = true;
           ...

       }
       ...

    } // while
} // main