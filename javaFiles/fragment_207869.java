protected int readInt(String prompt) {
    int i=-1;
    System.out.print(prompt);  
    try { 
        i = keyboard.nextInt();
        keyboard.nextLine();    
    } catch (java.util.InputMismatchException e) {
        System.out.println("Error: Insert a number.");
        keyboard.next();
    }
    return i;
}