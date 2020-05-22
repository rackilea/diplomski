public class RandomValueHolder {

private static ThreadLocal<Long> randomValue;

public static Long getRandomValue() {
    return randomValue.get();
}

public static void setRandomValue(Long value) {
    randomValue = new ThreadLocal<Long>();
    randomValue.set(value);

}
}