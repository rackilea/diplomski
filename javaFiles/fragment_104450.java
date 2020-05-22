...
@Persistent
private Set<Key> members; 

//getters setters

public void addMember(User member) {
    members.add(member.getKey());
    member.getGroups().add(this.getKey());
}

public void removeMember(User member) {
    members.remove(member.getKey());
    member.getGroups().remove(this.getKey());
}