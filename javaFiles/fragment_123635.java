@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

  private String gender;
  private Long counter;

  public MultiGauge.Row<UserData> toRow() {
    return MultiGauge.Row.of(Tags.of("gender", gender), this, c -> this.counter);
  }

}