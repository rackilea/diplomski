//compiler:"Okay, so passing in a List<Integer> or a List<Double> are both fine"
public void eatSomeNumbers(List<? extends Number> numbers) {
    for (Number number : numbers) {
        System.out.println("om nom " + number + " nom");
    }
}