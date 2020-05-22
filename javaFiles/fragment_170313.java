static Scanner console = new Scanner(System.in);

public static int getSide(String name) {

    System.out.println("What is the length of side " + name + "?");

    int a = console.nextInt();
    return a;
}