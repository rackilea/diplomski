@Entity
public class User{
  @Id
  private long id;

  @OneToOne
  @JoinColumn(name="GROUP_ID")
  private Group group;
  ...
}


@Entity
public class Group{
  @Id
  private long id;
  ...
}