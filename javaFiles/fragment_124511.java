public class Grouping<C,T> {
    C curr;
    List<T> subs;
    public C add(T comp) {
        this.subs.add(comp);
        return this.curr ;
    }
}

public class Business extends Grouping<Business,Group> {
    // Grouping::add does not need to be overriden
}
public class Group extends Grouping<Group,Area> {
    // Grouping::add does not need to be overriden
}