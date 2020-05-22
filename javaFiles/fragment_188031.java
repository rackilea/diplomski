public static void main(String[] args) {
    int year = 0;
    Scanner scan = new Scanner(System.in); 
    do{
        System.out.println("Enter a year or -1 to quit: ");
        year = scan.nextInt();
        while (year < 1582) { 
            System.out.print("The Gregorian calendar was not adopted until 1582, please enter a year after 1582: ");
            year = scan.nextInt(); 
        } 
        if(year != -1) { 
            System.out.println(isLeapYear(year));
        } 
    }while(year!=-1);
}