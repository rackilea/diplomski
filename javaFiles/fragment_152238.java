QueryBuilders
            .boolQuery()
            .must(QueryBuilders.termQuery("idGroups", 7078))
            .should(QueryBuilders.wildcardQuery("titre", "*fuite*"))
            .should(QueryBuilders.wildcardQuery("tag", "*fuite*"))
            .should(QueryBuilders.wildcardQuery("message", "*fuite*")).minimumShouldMatch(1);