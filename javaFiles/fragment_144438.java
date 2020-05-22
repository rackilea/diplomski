@Entity
public class Lang implements Serializable
{
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String key;

  @NotNull
  private String translation;
}