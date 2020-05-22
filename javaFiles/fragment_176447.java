while (!quit){
    Scanner keyIn = new Scanner(System.in);
    String c = "x";
    while (!c.equals("y") && !c.equals("n")) {
        c = keyIn.next();
    }
    if (c.equals("n"))
        quit = true;
}