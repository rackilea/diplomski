public static void main(String[] args) {

    SimpleIntegerProperty one = new SimpleIntegerProperty(1);
    SimpleIntegerProperty two = new SimpleIntegerProperty(0);

    // the binding we are interested in
    NumberBinding sum = one.add(two);
    sum.addListener(observable -> System.out.println("invalidated"));

    // if you add a value change listener, the value will NOT be evaluated lazy anymore
    //sum.addListener((observable, oldValue, newValue) -> System.out.println("value changed from " + oldValue + " to " + newValue));

    // is valid, since nothing changed so far
    System.out.println("sum valid: " + sum.isValid());
    // will invalidate the sum binding
    two.set(1);
    one.set(2); // invalidation event NOT fired here!
    System.out.println("sum valid: " + sum.isValid());
    // will validate the sum binding, since it is calculated lazy when getting the value
    System.out.println("sum: " + sum.getValue());
    System.out.println("sum valid: " + sum.isValid());
}