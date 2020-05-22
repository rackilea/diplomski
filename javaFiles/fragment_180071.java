import scala.collection.immutable.List;
import test.TypeEnum;
import test.Foo;

public class Test {
    public static void main(String[] args) {
        Foo foo = new Foo(TypeEnum.A(), null);
        System.out.println(foo.param1());
    }
}