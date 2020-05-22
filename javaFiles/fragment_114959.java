public class MilitaryPerson {

    private static final Rank DEFAULT_RANK = Rank.SOLDIER;

    private Rank rank;

    public MilitaryPerson() {
        this.rank = DEFAULT_RANK;
    }

    public MilitaryPerson(Rank rank) {
        this.rank = rank;
    }

    // ...

}