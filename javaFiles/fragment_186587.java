@Entity
public class Website {
  @Id
  @Column(name = "WEBSITE_ID")
  private long id;
  ...
  @OneToOne(mappedBy="website")
  private Player websiteOwner;
  ...
}