public class Temp {
    static int i;
    int j;
    int sum = i+j;

    public void setSum(){
        sum = i + j;
    }
    public int getSum(){
        return sum;
    }

}


public class Main{
    public static void main(String[] args){

    Temp obj = new Temp();
    obj.i = 1;
    obj.j = 2;
    obj.setSum();
    System.out.println(obj.sum); //OR obj.getSum()

    }
}