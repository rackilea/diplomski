public class WrongVersionOfWhyIsThisOk {

    int a = 10;

    public WhyIsThisOk (){
        a = 5;
    }

    public static void main(String[] args){
        WrongVersionOfWhyIsThisOk why = new WrongVersionOfWhyIsThisOk ();
        System.out.println(why.a);
    }
}