public class RandomNumberHandler {
    private Random rand;

    public RandomNumberHandler() {
        rand = new Random();
    }

    public void printOneRandom() {
        System.out.println(rand.nextInt());
    }
}