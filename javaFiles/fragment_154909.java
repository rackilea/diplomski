double sum = 0;
 void RR(double a, double b) {

    sum = (a + b) / 2.0;
 }
 public static void main(String[] args) {

    A myObject = new A();
    myObject.RR(5.5, 6.5);
    System.out.println(myObject.sum);

 }