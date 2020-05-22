public class Test {
    public static void main(String[] args) {
        Tamagotchi test = new Tamagotchi(10, 10, 10);
        test.play();
        test.makeHappy();

        System.out.println(test.getGeneralCondition());
    }
}