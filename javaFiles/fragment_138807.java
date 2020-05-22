public class NumberPicker<T>  {

    public interface OnChangedListener<Y> { //
        void onChanged(NumberPicker<Y> picker, Y oldVal, Y newVal);
    }

    public interface Formatter<X> {
        String toString(X value);
    }

    public void setFormatter( Formatter<T> formatter ) { ... }

    public static final NumberPicker.Formatter<? extends Number> TWO_DIGIT_FORMATTER =
        new NumberPicker.Formatter<Number>() {
            public String toString(Number value) {
                    // Do something with T value
            }
        };

}