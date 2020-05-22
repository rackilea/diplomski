import cats.Apply;
import cats.Semigroupal$;
import cats.instances.OptionInstances;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import scala.Option;
import scala.Tuple2;

public class Test {
  public static Apply<Option> getOptionInstance() {
    try {
      Class<?> cls = Class.forName("cats.instances.package$option$");
      Field f = cls.getField("MODULE$");
      Method m = f.getType().getMethod("catsStdInstancesForOption");
      return (Apply<Option>) m.invoke(f.get(null));
    } catch (Exception e) {
      // Shouldn't happen but do something here anyway.
      return null;
    }
  }

  public static void main(String[] args) {
    Apply<Option> optionInstance = getOptionInstance();

    Option<Tuple2<Integer, Integer>> pair = Semigroupal$.MODULE$.tuple2(
      Option.apply(1),
      Option.apply(2),
      optionInstance,
      optionInstance
    );

    System.out.println(pair);
  }
}