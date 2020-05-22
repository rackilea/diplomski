String query = "your query here";

        QueryBuilder matchQueryBuilder = QueryBuilders.boolQuery().must(new QueryStringQueryBuilder(query));

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(matchQueryBuilder);

        searchSourceBuilder.size(5000); //max is 10000

        searchRequest.indices("your index here");

        searchRequest.source(searchSourceBuilder);

        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(10L));

        searchRequest.scroll(scroll);

        SearchResponse searchResponse = client.search(searchRequest);
            String scrollId = searchResponse.getScrollId();

        SearchHit[] allHits = new SearchHit[0];

        SearchHit[] searchHits = searchResponse.getHits().getHits();

        while (searchHits != null && searchHits.length > 0)
        {

            allHits = Helper.concatenate(allHits, searchResponse.getHits().getHits()); //create a function which concatenate two arrays

            SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);

            scrollRequest.scroll(scroll);

            searchResponse = client.searchScroll(scrollRequest);

            scrollId = searchResponse.getScrollId();

            searchHits = searchResponse.getHits().getHits();

        }

        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
        clearScrollRequest.addScrollId(scrollId);
        ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest);