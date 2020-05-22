public class RandomNumberHandler {
    private Random rand = new Random();

    public void printOneRandom() {
        System.out.println(rand.nextInt());
    }
}