public static void main (String [] args) {
        String input;
        Scanner console = new Scanner(System.in);

        System.out.print("enter text: ");
        input = console.nextLine(); // Change here
        System.out.println();

        input = input.replaceAll(" ", ""); // Change here
        System.out.println(input);
}