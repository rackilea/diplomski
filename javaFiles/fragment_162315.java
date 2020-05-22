@Entity
@IdClass(FluxId.class)
public class Flux {         

  @Id
  private Source source;

  @Id
  private BigDecimal band;

 // With constructors, getters and setters

}