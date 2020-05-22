import fj.F; import fj.F2;
import fj.data.Option;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static fj.Function.curry;
import static fj.Option.some;
import static fj.Option.none;
...

F<String, F<String, Option<Date>>> parseDate =
  curry(new F2<String, String, Option<Date>>() {
    public Option<Date> f(String pattern, String s) {
      try {
        return some(new SimpleDateFormat(pattern).parse(s));
      }
      catch (ParseException e) {
        return none();
      }
    }
  });