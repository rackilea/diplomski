@Entity
@Table(name = "Store")
public class Store implements Identifiable {

    @OneToOne(optional = true)
    @JoinColumn(name = "CostCenterNumber", referencedColumnName="dennskdnr")
    private MasterData masterData;

}

@Entity
@Table(name = "MasterData")
public class MasterData {

    @OneToOne(optional = true, mappedBy = "masterData")
    private Store store;

}