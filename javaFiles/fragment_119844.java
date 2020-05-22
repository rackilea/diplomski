@Entity
@Table(name = "activity")
public class Activity {
  ...
  private Duration duration;

  @Column(name = "duration", updatable = false, insertable = false) //mapped to the same columnn!
  private int durationNumeric
   ...
}