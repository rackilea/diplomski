public static void case2sub() {
    boolean end = false;
    while (!end)
    {
    end = false;
    System.out.println("Start of option 2");
    //option 2 will do things here
    System.out.println("End of option 2");
    //I want to return at the beginning of this case at the end of it
    System.out.println("QUIT? (Y/N)");
    keyboardInput =  new Scanner(System.in).nextLine();
    if (keyboardInput.equalsIgnoreCase("Y"))
        end = true;
    }
}