public static String getCommand() {
    Scanner s = new Scanner(System.in);
    boolean containsCommand;
    String nextCommand;
    do {
        nextCommand = s.nextLine();
        containsCommand = false;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(nextCommand) {
                containsCommand = true;
                return nextCommand;
            }    
        } 
        if (!containsCommand) {
            System.out.println("please enter valid option");
        }
    while(!containsCommand); 
}