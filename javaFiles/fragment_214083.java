public static void main(String[] args) 
{
    Scanner peace = new Scanner(System.in);
    System.out.print("How many subjects do you want to enter?: ");
    int a = peace.nextInt();
    String[] b = new String[a];
    for(int i = 0; i < a; i++) {
        System.out.print("Enter Subject No " + (i + 1) + " ");
        b[i] = peace.next();
    }
    for(i = 0; i < b.length; i++) {
        System.out.print(b[i] + " ");
    }
}