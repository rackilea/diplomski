public static void main(String[] args) {
    int x = 1;
    double y = 3.4;
    System.out.println(x+" "+y);//<<-------- 1- This will print 1 3.4
    changeUs(x, y);
    System.out.println(x+" "+y);//<<-------- 3- This will print 1 3.4        
}

public static void changeUs(int x, double y) {
    x = 0;
    y = 0.0;
    System.out.println(x +" "+y);//<<-------- 2- This will print 0 0.0
}