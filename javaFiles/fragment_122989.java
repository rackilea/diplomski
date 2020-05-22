static double a,b,c,d;  //If you leave these outside your method, it has to be static
    static Scanner sc = new Scanner(System.in); //This as well

    public static void main(String[] args) {

        System.out.println("Enter your numbers ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();
        double e = (a+b+c+d)/4; //Do math after we save the numbers
        System.out.println(e);

    }