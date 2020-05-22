protected List<myNamespace.Member> members;
public List<myNamespace.Member> getMembers() {
    if (members == null) {
        members = new ArrayList<myNamespace.Member>();
    }
    return this.members;
}