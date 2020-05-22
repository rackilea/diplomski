SolrServer solr = new CommonsHttpSolrServer("http://localhost:8080/solr");
ModifiableSolrParams params = new ModifiableSolrParams();
params.set("qt", "/spell");
params.set("q", "whatever");
params.set("spellcheck", "on");
//params.set("spellcheck.build", "true");

QueryResponse response = solr.query(params);
SpellCheckResponse spellCheckResponse = response.getSpellCheckResponse();
if (!spellCheckResponse.isCorrectlySpelled()) {
    for (Suggestion suggestion : response.getSpellCheckResponse().getSuggestions()) {
        logger.debug("original token: " + suggestion.getToken() + " - alternatives: " + suggestion.getAlternatives());
    }
}