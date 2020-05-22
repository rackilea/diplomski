public interface Barista {

    @Input
    SubscribableChannel orders();

    @Output
    MessageChannel hotDrinks();

    @Output
    MessageChannel coldDrinks();
}

...
@EnableBinding(Barista.class)
public class CafeConfiguration {