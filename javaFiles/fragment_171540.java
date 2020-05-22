public class Company 
{
    ...

    @OneToMany(mappedBy = "company")
    @Where(clause = "parent_id is null")
    private List<Branch> branches;

    @OneToMany(mappedBy = "company")
    private List<User> users;
}