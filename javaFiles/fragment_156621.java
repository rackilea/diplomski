@Embeddable
public class UserGroupMembership implements Serializable {

    @ManyToOne
    @JoinColumnsOrFormulas(
        value = {
            @JoinColumnOrFormula(column = @JoinColumn(referencedColumnName = "userid", name = "userid")),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "department", value = "department"))
        })
    private User user;

    public UserGroupMembership(User user) {
        this.user = user;
    }

    public UserGroupMembership() {
    }

    public User getUser() {
        return user;
    }
}