import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders.*;

BoolQueryBuilder query = QueryBuilders.boolQuery()
    .must(QueryBuilders.matchQuery("name", "abc"))       // 1.
    .filter(QueryBuilders.termQuery("id", "test.com"));  // 2.

SearchResponse response = client.prepareSearch("ecommerce_index")
        .setTypes("ecommerce_type")
        .setQuery(query)
        .setFetchSource(new String[]{"status"}, null)    // 3.
        .setFrom(0)
        .setSize(10)
        .execute()
        .actionGet();