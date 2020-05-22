// I'm not sure whether annotations (@JsonTypeInfo) on class level are supported as well to allow the polymorphistic type decision.
abstract class MixIn {

  // make constructor usable if available
  MixIn(@JsonProperty("id") int a, @JsonProperty("name") String b) { }

  @JsonDeserialize(using=CostumDeserializer.class) abstract TypeX getTypeX();

}