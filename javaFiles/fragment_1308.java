public class Martian extends Alien {
    public Martian(String p, String a, String n, String s, String ap) {
        super(p, a, n, s, ap);
    }

    @Override
    public void invade(String planetName, InvadingStrategy strategy) {
        System.out.println("I am Martian, I am going to invade " + planetName + " and My Strategy will be "
                + strategy.getStrategyDescription());
    }
}