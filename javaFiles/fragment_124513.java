public class Business {
    List<Group> subs;
    public Business add(Group comp) {
        this.subs.add(comp);
        return this ;
    }
}
public class Group {
    List<Area> subs;
    public Group add(Area comp) {
        this.subs.add(comp);
        return this ;
    }
}