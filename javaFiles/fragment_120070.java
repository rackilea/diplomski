public Salaried() {
    super();
    System.out.println("What is this employees salary?");
    Scanner sc1 = new Scanner(System.in);
    double p = sc1.nextDouble();
    sc1.nextLine(); // <-- consume trailing new line.
    System.out.println("Give this employee a bonus? Y/N");
    bonus = sc1.nextLine().equalsIgnoreCase("Y"); // <-- just set bonus.
    if (bonus) {
        setPay(p * 1.1);
    } else {
        setPay(p);
    }
}