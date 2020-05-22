@Entity
@Table(name = "USER_DETAILS")
public class UserDetail {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  // no setter for this field
  private UUID userId;

  @Column(nullable = false)
  private boolean married;

  public UserDetail(User user, boolean isMarried) {
    this.id = UUID.randomUUID();
    this.userId = user.getId();
    this.married = isMarried;
  }

  // Constructors, Getters, Setters, ...

}