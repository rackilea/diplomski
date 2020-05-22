public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter a string:\t");
        String word = scanner.nextLine();

        System.out.print("Enter an integer:\t");
        int index = scanner.nextInt();

        System.out.println("Character at position " + index + ": " + word.charAt(index));
    }