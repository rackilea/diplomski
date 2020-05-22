public static void main(String[]args) {
    double max = 0.0d;
    for(int i=0; i < 1000000; i++){
        double x = Math.random();
        max = Math.max(max,x);
        System.out.println(x);
    }
    System.out.println("The maximum is "+max);
}