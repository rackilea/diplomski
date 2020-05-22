import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.SolrClient;
import org.example.ronvisbord.solr.queries.custom.HeightFunctionQuery;
import org.apache.lucene.search.Query;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.response.QueryResponse;

...

    double boost = 10.0;
    double targetHeight = 8;
    String heightField = "height";

    Query heightQuery = new HeightFunctionQuery(targetHeight, boost);
    SolrQuery solrQuery = new SolrQuery();
    solrQuery.set("q", heightQuery.toString(heightField));
    // ... further configure the solrQuery ...

    SolrClient client = new HttpSolrClient("http://solr_host:8983/solr/core")
    QueryResponse response = client.query(query, SolrRequest.METHOD.POST)
    // ... process results ...