@Getter
@ToString
@RequiredArgsConstructor
public final class Entity {

  private final String code;
  private final String name;
  private final int version;

  public static void main(String[] args) {
    final List<Entity> entities = Arrays.asList(
      new Entity("code1", "Name1", 1),
      new Entity("code1", "Name1", 2),
      new Entity("code1", "Name1", 3),
      new Entity("code1", "Name1", 3),
      new Entity("code2", "Name2", 1),
      new Entity("code2", "Name2", 2)
    );

    final Map<String, Optional<Entity>> result = entities.stream()
      .collect(Collectors.groupingBy(Entity::getCode,
        Collectors.maxBy(Comparator.comparingInt(Entity::getVersion))));

    System.out.println(result);
    // {
    //  code2=Optional[Entity(code=code2, name=Name2, version=2)], 
    //  code1=Optional[Entity(code=code1, name=Name1, version=3)]
    // }
  }

}