public class User {

    @OneToMany(mapedBy="user", cascade=ALL, orphanRemoval=true)
    private final Set<Actions> actions = new HashSet<Actions>();

     // Getter only, no setter!
     public Set<Actions> getActions() {
         return Collections.unmodifiableSet(this.actions);
     }

     public void addActions(Actions actions) {
          this.actions.add(actions);
          actions.setUser(this); // Only if bi-directional relation
     }

     public void removeActions(Actions actions) {
          this.actions.remove(actions);
          actions.setUser(null);
     }
}