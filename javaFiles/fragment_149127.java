public class Unit implements Comparable<Unit> {

    private int id;

    private String name;

    // Constructor

    // Methods

    @Override
    public int compareTo(Unit other) {
        // sorts by id
        return this.id - other.id;
        // to sort by name, use this:
        // return this.name.compareTo(other.name);
  }
}