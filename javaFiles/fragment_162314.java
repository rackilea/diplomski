@Embeddable
public class FluxId implements Serializable {

  @ManyToOne
  @JoinColumn(name="source")
  private Star star;

  @Column(name = "band", nullable = false)
  private BigDecimal band;

  // With constructors, getters and setters

}