final char arr[] = new char[10];
    System.out.println("Enter 10 chars");
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < arr.length; i++) {
        arr[i] = ((String) input.next()).charAt(0);
        }

    System.out.print("Enter the number to find its place: ");
    char num=((String) input.next()).charAt(0);
    int n = search.find(arr, num);
    if ((n >= 0) && (n < arr.length)) {
        System.out.println("Found at element: " + n);
    } else {
        System.out.println("Not Found");
    }