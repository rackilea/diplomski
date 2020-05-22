public class RightVersionOfWhyIsThisOk {

    int a;

    public RightVersionOfWhyIsThisOk (){
        a = 5;
        a = 10;
    }

    public static void main(String[] args){
        RightVersionOfWhyIsThisOk why = new RightVersionOfWhyIsThisOk ();
        System.out.println(why.a);
    }
}