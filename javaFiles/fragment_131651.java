int getInt(String prompt) {
    System.out.print(prompt);
    while(true){
        try {
            return Integer.parseInt(new Scanner(System.in).next());
        } catch(NumberFormatException ne) {
            System.out.print("That's not a whole number.\n"+prompt);
        }
    }
}