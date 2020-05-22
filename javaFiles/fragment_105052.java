CompletionSuggestionBuilder skillNameSuggest  = new CompletionSuggestionBuilder("complete");
skillNameSuggest.text("es");
skillNameSuggest.field("completion_suggest");

SearchResponse searchResponse = client.prepareSearch("kodcucom")
        .setTypes("article")
        .setQuery(QueryBuilders.matchAllQuery())
        .addSuggestion(skillNameSuggest)
        .execute().actionGet();

CompletionSuggestion compSuggestion = searchResponse.getSuggest().getSuggestion("complete");

List<CompletionSuggestion.Entry> entryList = compSuggestion.getEntries();
if(entryList != null) {
    CompletionSuggestion.Entry entry = entryList.get(0);
    List<CompletionSuggestion.Entry.Option> options =entry.getOptions();
    if(options != null)  {
        CompletionSuggestion.Entry.Option option = options.get(0);
        System.out.println(option.getText().string());
    }
}