public class HeroesGroup extends CharactersGroup<Hero> {

    public HeroesGroup() {
        this(new ArrayList<Hero>());
    }

    public HeroesGroup(ArrayList<Hero> list) {
        super(list);
    }
}