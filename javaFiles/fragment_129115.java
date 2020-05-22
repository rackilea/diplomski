import static org.elasticsearch.index.query.QueryBuilders.*;

SearchResponse response =
    client.prepareSearch("your-index").setTypes("your-type")
          .setQuery(
               boolQuery()
                   .must(matchPhraseQuery("title", "main title"))
                   .must(termsQuery("tags", "first", "page"))
          .execute()
          .actionGet();