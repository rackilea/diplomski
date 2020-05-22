@Entity
@Cache
public class Message
{
    @Id Long id;
    @Load @Parent private Ref<User> user;

    public User getUser() { return this.user.get(); }
    public void setUser(User value) { this.user = Ref.Create(value); }
}