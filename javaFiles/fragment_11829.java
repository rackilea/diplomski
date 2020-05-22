public static void main(String[] args) {

    Scanner userInput = new Scanner(System.in);

    System.out.print("Board size NxN: ");
    try {
        int width = userInput.nextInt();
        int height = userInput.nextInt();
        if (userInput.hasNext()) {
            throw new IllegalArgumentException();
        }
    } catch (IllegalArgumentException e) {
        System.err.println("Enter just two numbers");
    }
}