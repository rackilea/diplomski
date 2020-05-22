public class MultMethods{
public static void main(String[] args){
    String str = anotherMethod();
    printMethod(str);
}
public static String anotherMethod(){
    String value = "ABC";
    return value;
}

public static void printMethod(String str){
    System.out.println(str);
}
}