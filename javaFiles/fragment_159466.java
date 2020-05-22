@Entity
public class O {

    @Id
    private Long id;

    @ElementCollection
    @CollectionTable( name = "OD")
    private Set<OD> ods;
}

@Embeddable
public class OD {

    // This is uni-directional reln
    @OneToOne
    private D d;

    private int count;
}