public class User{
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Membership> memberships = new HashSet<Membership>(0);

    //if required, you can 'hide' the join entity from client code by    
    //encapsulating add remove operations etc.

    public void addToGroup(Group group){
        Membership membershup = new Membership();
        membership.setUser(this);
        membership.setGroup(group);
        memberships.add(membership);
    )

    public Set<Groupp> getGroups(){
        //iterate memberships and build collection of groups
    }
}