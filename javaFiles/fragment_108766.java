private int NUM;
private int DEN;
static Scanner s;
public Rational(){
    System.out.println("Enter Rational number in the form of a/b:");
    s = new Scanner(System.in);
    String[] values = s.next().split("/");

    NUM = Integer.parseInt(values[0]);
    int d = Integer.parseInt(values[1]);
    if(d == 0){
        throw new IllegalArgumentException();
    } else{
        DEN = d;
    }
}