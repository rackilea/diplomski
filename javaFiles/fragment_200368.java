public void enterPassenger(int i) {
//        Scanner kb = new Scanner(System.in);
    // asks the important questions
    System.out.print("Enter passenger #" + i + "’s name: ");
    name = RunAirLine.kb.nextLine();
    System.out.println("Enter passenger #" + i + "’s food option ");
    System.out.print("(V = vegetarian, N = no preference, H = Halal): ");
    foodOption = RunAirLine.kb.nextLine().toUpperCase().charAt(0);
    System.out.print("Enter passenger #" + i
        + "’s class (1 = first, 2 = business, 3 = economy): ");
    seatClass = RunAirLine.kb.nextInt();
    RunAirLine.kb.nextLine();