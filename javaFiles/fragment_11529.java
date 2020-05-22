public abstract class BaseClass<S extends SolrServer>{
    public abstract void addDocs(S server);
}

public class ImplementingClass extends BaseClass<SomeSolrServer>{
    public void addDocs(SomeSolrServer server){
        // do stuff here
    }
}