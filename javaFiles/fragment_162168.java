public int sum(String s) {
    int i = 0;
    Scanner in = new Scanner(s);
    while (in.hasNextInt())  {        
        i += in.nextInt();     
    }
    return i;
}