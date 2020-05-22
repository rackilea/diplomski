@Setter
@Getter
@Builder
public class MyData {
  private Long id;
  private String name;

  @Builder.Default
  private Status status = Status.NEW;
}