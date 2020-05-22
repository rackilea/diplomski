@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo {
  private Option<String> bar = Option.none(); // If the JSON field is null or not present, the field will be initialized with none
}