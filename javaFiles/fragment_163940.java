public interface ShakesHands {

    String name = "Gabe";

    public void shakeHands(ShakesHands other);
}

class Student implements ShakesHands {

    Integer name = Integer.valueOf(0);

    @Override
    public void shakeHands(ShakesHands other) {
        System.out.println(name.getClass().getSimpleName() + " (in this class) with value "+name+" vs. " + other.name.getClass().getSimpleName()+" (in other class) with value "+other.name);
    }
}