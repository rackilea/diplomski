public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String input = "";

    while (!(input = sc.next()).equals("exit")) {
        int i1 = Integer.parseInt(input);
        int i2 = sc.nextInt();

        if ((i1 % i2) == 0)
            System.out.println(i1 + "divisible" + i2);
        else
            System.out.println("Not divisible");
    }
}