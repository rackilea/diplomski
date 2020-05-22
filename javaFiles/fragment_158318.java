public class ParentsHolder extends Model {
    List<Parent> parents = new ArrayList<>();

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        firePropertyChange("parents", this.parents, this.parents = parents);
    }

    public void addParent(Parent p) {
        List<Parent> newlist = new ArrayList<>(parents);
        newlist.add(p);
        setParents(newlist);
    }
}