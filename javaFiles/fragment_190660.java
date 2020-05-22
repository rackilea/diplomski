@Value.Immutable
@JsonSerialize(as = ImmutableOperation.class)
@JsonDeserialize(as = ImmutableOperation.class)
public abstract class Operation {    

  @JsonAnyGetter
  @Value.Parameter
  public abstract Map<String, String> extra();
}