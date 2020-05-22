enum Monster {
    GOBLIN, ORC, OGRE;
}

public class Main {
    public static void main(final String[] args) {
        final EnumSet<Monster> bigGuys = EnumSet.of(Monster.ORC, Monster.OGRE);

        for (final Monster act : Monster.values()) {
            System.out.println(bigGuys.contains(act));
        }
    }
}