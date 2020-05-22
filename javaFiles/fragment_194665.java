public static void main(String args[]) {

    int n,c;
    char search,array[];

    Scanner in = new Scanner(System.in);
    System.out.println("Enter number of elements");
     n = in.nextInt();
    array = new char[n];

    System.out.println("Enter " + n + " Letters");

    for ( c = 0; c < n; c++) {
        array[c] = in.next().charAt(0);
    }

    System.out.println("What letter do you want to find?");
    search = in.next().charAt(0);

    for ( c = 0; c < n; c++) {
        if (array[c] == search) /* Searching element is present */ {
            System.out.println(search + " is present at location " + (c + 1) + ".");
            break;
        }
        if (c == n) /* Searching element is absent */ {
            System.out.println(search + " Letter is not found.");
        }
    }
}