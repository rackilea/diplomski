@FunctionalInterface
public interface TriConsumer {

    abstract void consume(Object before, Object current, Object after);

}

public static final forContext(Object[] arr, TriConsumer consumer){
    if (arr == null) {
        return;
    }
    for (int i = 0; i < arr.length; i++){
        consumer.consume(i == 0 ? null : arr[i - 1], arr[i], i == arr.length - 1 ? null : arr[i + 1]);
    }
}