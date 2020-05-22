@Entity
@Table(name = "memberships")
public class Memberships implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Id
  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  @Column(name = "status")
  private Integer status;

}