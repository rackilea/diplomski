public class A {

    public static void main(String[]s){

        show(5);
        show("hello");
    }
    public static void show(Object obj){
        if(obj instanceof Integer){
            System.out.println((Integer)obj);
        }else if(obj instanceof String){
            System.out.println((String)obj);
        }
    }
}