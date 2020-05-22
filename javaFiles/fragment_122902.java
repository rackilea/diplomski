public static int add(Scanner sc) {    
    if (sc.hasNextInt()) {
        int val = sc.nextInt();    
        return val + add(sc);                                
    }
    return 0; // No more values in the Scanner to add
}