public abstract class CharactersGroup<C extends Character> {
    private ArrayList<C> characters;

    public CharactersGroup() {
        this(new ArrayList<C>());
    }

    public CharactersGroup(ArrayList<C> list) {
        characters = list;
    }
}