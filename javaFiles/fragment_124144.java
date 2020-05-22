import java.lang.reflect.Type;


public class A implements Type{
    public static void main(String [] arg){
        new A().run();
    }

    public void run(){
        System.out.println( Type.super.getTypeName() );
    }

}