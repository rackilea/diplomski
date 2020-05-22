public static Scanner rew = new Scanner(System.in);

public static void main(String[] args) {
    int dec;
    do {
        System.out.println("Input info:");
        String name=stringGetter("Name: ");
        String yearandsec=stringGetter("Year and section: ");
        dec=rew.nextInt();
    } while(dec==1);
}

public static String stringGetter(String ny){
    System.out.println(ny);
    return rew.nextLine();
}