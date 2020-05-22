class x {
    int a_x[] = new int[2];
    x() {
        a_x[0] = 10; a_x[1] = 20; 
    }

}
class y extends x {
    int a_y[] = new int[10];
    y() {
        a_y[0] = 12000; a_y[1] = 1000; a_y[2] = 120;
    }
}

class Override2 {
    public static void main(String[] args) {
        x obj1 = new x();
        x obj2 = new y();
        y obj4 = new y();
        System.out.println(obj1.a_x[1]);
        System.out.println(obj2.a_x[1]);
        System.out.println(obj4.a_y[1]);
    }
}