public static void main(String[]args)   {
    FileManager fm = new FileManager();  // Creates an instance
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter a command");
    String command = sc.next();
    if (command.equals("down")) // equals will suffice in this case
                                // or equalsIgnoreCase() if you dont want case to be a problem
        fm.down(); // Notice now this calls the down method from the instance
    //else if is on the way
}