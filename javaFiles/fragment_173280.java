import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;

public class DataTest extends WebAppConfigurationAware{

    @Autowired
    private DataRepository dataRepository;

    @Test
    public void testStringDataCompoundQuery(){
        Object[] objArr = new Object[2];
        objArr[0] = "aaa";
        objArr[1] = 1;

        Query query = new Query();
        query.setKey(ComplexKey.of(objArr));

        System.out.println(dataRepository.findByKey1AndKey2(query));

    }
}