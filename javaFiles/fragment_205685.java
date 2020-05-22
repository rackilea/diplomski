@Embeddable
public class BPK implements serializable {
  ....
  private A a;

  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumns ({
    @JoinColumn(name="...", referencedColumnName = "..."),
    @JoinColumn(name="...", referencedColumnName = "..."),
    ...
  })
  public getA() {
    return this.a;
  }
}