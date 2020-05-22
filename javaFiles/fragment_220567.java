@Entity
public class Sale {
    @Embeddable
    public static class Pk implements Serializable {
        @Column(nullable = false, updatable = false)
        private Long soldById;

        @Column(nullable = false, updatable = false)
        private Long buyerId;

        @Column(nullable = false, updatable = false)
        private Long productId;

        public Pk() {}

        public Pk(Long soldById, Long buyerId, Long productId) { ... }

        // getters, setters, equals, hashCode
    }

    @EmbeddedId
    private Pk pk;

    @ManyToOne
    @JoinColumn(name = "SOLDBYID", insertable = false, updatable = false)
    private SaleAssistant soldBy;
    @ManyToOne
    @JoinColumn(name = "BUYERID", insertable = false, updatable = false)
    private Customer buyer;
    @ManyToOne
    @JoinColumn(name = "PRODUCTID", insertable = false, updatable = false)
    private Product product;

    // getters, setters, equals, hashCode
}