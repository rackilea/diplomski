@Entity
@Table(name="user_profession")
// i have no idea why you need such JSONIgnore, but ok
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profession implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
@Column(name="id")
private long id;

@Column(name="u_id")
private long uid;

@Column(name="profession")
private String profession;

@Column(name="type")
private String professionType;

@ManyToOne
 @JoinColumn(name = "userid", nullable = false)
    private User usersProfession
// getters and metters
}