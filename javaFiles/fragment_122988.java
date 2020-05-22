public static void main(String[] args) {
        double a,b,c,d;  //These don't have to be static, if they are inside your method. 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your numbers ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();
        double e = (a+b+c+d)/4;  //Do math after we save the numbers
        System.out.println(e);
    }