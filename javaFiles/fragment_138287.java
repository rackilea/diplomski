@Entity(name = "RestMethod")
public class RestMethodImpl implements RestMethod {

    // ...  
    @ManyToOne(targetEntity=DataProviderImpl.class, fetch = FetchType.LAZY)
    @JoinColumn(name="dataProviderId")
    private DataProvider dataProvider;