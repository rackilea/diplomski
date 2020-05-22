public class Grouping<T> {
    List<T> subs;
    public void add(T comp) {
        this.subs.add(comp);
    }
}

public class Business extends Grouping<Group> {
    // Grouping::add does not need to be overriden
}
public class Group extends Grouping<Area> {
    // Grouping::add does not need to be overriden
}