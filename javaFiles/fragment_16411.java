@Embeddable
class JobEndPointPK {
    @Column(name = "type", nullable = false)
    @Enumerated
    EndPointType type;

    @Column(name = "zipCode", nullable = false)
    String zipCode;

    @Column(name = "customerNumber", nullable = false)
    int customerId;

    // equals, hasCode, getters, setters etc.
}

@Entity
class JobEndPoint {
    @Id
    private JobEndPointPK key;

    // getters, setters etc.
}