@Entity
public class Verification implements Serializable {
    private Long verificationId;

    private Long salesManCode;
    private Long clientCode;
    ...
}

@Entity
public class Contract implements Serializable {
    private Long contractId;        

    @MapsId
    @OneToOne
    @JoinColumn(name = "contractId", referencedColumnName = "verificationId")
    private Verification verification;

    private Long salesManCode;
    private Long clientCode;
}