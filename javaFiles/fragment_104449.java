...
@Persistent
private Set<Key> groups; 

//getters setters

public void addGroup(Group group) {
    groups.add(group.getKey());
    group.getMembers().add(this.getKey());
}

public void removeGroup(Group group) {
    groups.remove(group.getKey());
    group.getMembers().remove(this.getKey());
}