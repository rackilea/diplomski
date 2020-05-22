Scanner x = new Scanner(System.in);
    int n;
    System.out.print("Enter how many numbers to display");
    n = x.nextInt();

    int count = 0;
    int i = 1;
    while (count < n) {                     //is this right?            
        if (count % 2 == 0) {
            System.out.print(i + " ");
            i += 2;
        } else {
            System.out.print(i + " ");
            i += 3;                
        }            
        count++;
    }