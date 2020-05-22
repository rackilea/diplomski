public class Test {
    public static void foo(StringBuilder errorText){ 
        errorText.delete(0, errorText.length());
        errorText.append("bla bla");
    }

    public static void main(String[] args) { 
        StringBuilder error=new StringBuilder("initial");
        foo(error); 
        System.out.println(error);
    }
}