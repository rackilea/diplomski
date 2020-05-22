Scanner in = new Scanner(System.in);

while(in.hasNextLine()) {
    int x = in.nextInt();
    int y = in.nextInt();

    if(x <= 40 && y <= 40)
        method(x, y); 
}