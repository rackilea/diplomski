public interface Validator<T> {

    boolean validate(T... objects);
}

public class StringValidator implements Validator<String> {

    @Override
    public boolean validate(String... objects) {
        return false;
    }
}