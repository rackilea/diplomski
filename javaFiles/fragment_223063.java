import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.$colon$colon;

public class HelloScalaList {

    public static void main (String[] args) {
        List xs = list(1,2,3);
        System.out.println(xs);
    }

    public static <T> List<T> list(T ... ts) {
        List<T> result = List$.MODULE$.empty();
        for(int i = ts.length; i > 0; i--) {
            result = new $colon$colon(ts[i - 1], result);
        }
        return result;
    }
}