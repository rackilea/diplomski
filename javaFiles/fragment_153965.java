public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer group = null;
    do {
        try {
            System.out.print("How many people are in your group? ");
            String input = sc.next();
            group = Integer.parseInt(input);
            System.out.println("Okey, " + group + " people");
        } catch (NumberFormatException e) {
            System.out.println("Error, please enter a numerical value");
        }
    } while(group == null);
}