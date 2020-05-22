public class Recursion1 {
private static int endValue;
private static int startValue = 1 ;

public Recursion1(int endValue){
    Recursion1.endValue = endValue;
}

public static void main(String[] args) {
    Recursion1 me = new Recursion1(4);
    me.doIt();
}

public void doIt() {        
    nums("*");
}

public String nums(String value) {
    if( startValue == endValue){
        System.out.println(value);
    }else{
        System.out.println(value);
        startValue ++;
        value = value.concat("*");
        nums(value);
        value = value.substring(1);
        System.out.println(value);
    }
    return value;
}}