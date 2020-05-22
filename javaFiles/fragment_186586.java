@Entity
public class Player {
  @Id
  @Column(name="PLAYER_ID")
  private long id;
  ...
  @OneToOne
  @JoinColumn(name="WEBSITE_ID")
  private Website website;
  ...
}