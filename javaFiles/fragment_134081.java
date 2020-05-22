import java.util.Optional;

public class Val implements Expr{

    Optional<Integer> value;

    public Val(int value) {
        this.value = Optional.of(value);
    }

    @Override
    public Optional<Integer> eval() {
        return value;
    }
}