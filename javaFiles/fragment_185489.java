@Entity
public class SomeEntity  {
  @Id
  private Long id;

  @Type( "your.custom.UserVersionType" )
  @Version
  private Updateable updateAudit;

  // other stuff
}