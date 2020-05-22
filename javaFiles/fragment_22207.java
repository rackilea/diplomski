public String getName(){
    String name = scanner.nextLine();
    if(name.equals("whatever it is you want to end program"))
        System.exit(0);
    else
        return name;
}