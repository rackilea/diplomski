$cat X.java  

import java.lang.reflect.Method;


public class X {
    public static void main( String [] args ) {
        for( Method m : X.class.getMethods() ) {
            if( m.getReturnType().equals(Void.TYPE)){
                System.out.println( m.getName()  + " returns void ");
            }
        }
    }

    public void hello(){}
}
$java X
hello returns void 
main returns void 
wait returns void 
wait returns void 
wait returns void 
notify returns void 
notifyAll returns void