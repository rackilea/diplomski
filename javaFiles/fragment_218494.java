public class MyClass  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected T id;

    @Column
    protected String clientKey;

    @PrePersist
    public void ensureClientKeyGenerated() {
          this.clientKey = UUID.randomUUID();  
    }

}