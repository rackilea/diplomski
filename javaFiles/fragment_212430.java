@Data
@Builder
public class TweakedFoo {
    // ...
    public static TweakedFooBuilder builder(Class<Foo> from, Mode mode) {
        return new TweakedFooBuilder()
            .from(from)
            .mode(mode);
    }
    // ...
}