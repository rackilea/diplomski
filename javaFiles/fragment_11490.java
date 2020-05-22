public static void main(String[] args) {

    String name;

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter your name");


    name = sc.nextLine();

    sc.close();

    System.out.println("Your name " + name);

}