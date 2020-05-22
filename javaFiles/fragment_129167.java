@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Model {

  @JsonDeserialize(using = ToLowerCaseDeserializer.class)
  private String email;

  @JsonDeserialize(using = ToLowerCaseDeserializer.class)
  private String username;
}