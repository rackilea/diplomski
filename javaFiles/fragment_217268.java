import fj.data.List;
import static fj.data.Stream.stream;
import static fj.data.Option.isSome_;
....
public Option<Date> parseWithPatterns(String s, Stream<String> patterns) { 
  return stream(s).apply(patterns.map(parseDate)).find(isSome_()); 
}