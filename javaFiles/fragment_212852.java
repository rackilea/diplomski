import java.util.*;
import static java.lang.System.out;

class SubListExample {
    public static void main( String [] args ) {
        List<RandomObject> testList = new ArrayList<RandomObject>();
        for(int i=0;i<10;i++) {
            testList.add( new RandomObject() );
        }

        System.out.println( "Before: " + testList );
        testList.subList(0, 5).clear();
        System.out.println( "After: "+ testList );
    }
}
class RandomObject {
    static Random generator = new Random();
    int id = generator.nextInt(100);
    public String toString(){
        return "ro("+id+")";
    }
}