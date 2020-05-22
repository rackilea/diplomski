public static void main(String[] args) {
    double x = 0.1;
    double x2 = Math.pow(x,2);


    double y = 4*x2 + 5*x - 3;
    double counter = 0.1;

    while(counter <= 1.0)
    {
        System.out.print(y);

        counter += 0.1;

        //re-evaluate x, x2, and y here
        x += 0.1;
        x2 = Math.pow(x,2);
        y = 4*x2 + 5*x - 3;
    }
}