public static void main(String... obj) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter number of Players");
    Integer p = Integer.valueOf(s.nextLine());
    System.out.println("Enter number of Teams");
    Integer t = Integer.valueOf(s.nextLine());

    List<String> listp = new ArrayList<>();
    for (int i = 0; i < p; i++){
        System.out.println("Enter Player name " + i);
        listp.add(s.nextLine());
    }
    List<String> listt = new ArrayList<>();
    for (int i = 1; i < t; i++){
        System.out.println("Enter Team name " + i);
        listt.add(s.nextLine());
    }
}