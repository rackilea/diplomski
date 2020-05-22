public class CreatureAi {
    private Creature creature;

    public CreatureAi(){}

    public CreatureAi(Creature creature) {
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }
    // There's more, I'm shortening it.