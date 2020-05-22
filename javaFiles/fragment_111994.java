@Value.Immutable
public interface ValueObject {
  String name();
  List<Integer> counts();
  Optional<String> description();
}

// Compile using annotation processor and use it like this
ValueObject valueObject =
   ImmutableValueObject.builder()
      .name("My value")
      .addCounts(1)
      .addCounts(2)
      .build();