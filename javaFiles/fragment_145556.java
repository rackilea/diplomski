final MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery("Bababooey", "title^0.8", "url^0.6", "description^0.3").type(MultiMatchQueryBuilder.Type.BEST_FIELDS);

final FunctionScoreQueryBuilder functionScoreQuery = QueryBuilders.functionScoreQuery(multiMatchQuery);
functionScoreQuery.scoreMode("multiply");
functionScoreQuery.boostMode(CombineFunction.MULT);
functionScoreQuery.add(ScoreFunctionBuilders.gaussDecayFunction("postDate","130w").setOffset("26w").setDecay(0.3));