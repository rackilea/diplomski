public Observable<Map<String, JsonObject>> extractTopLevelSummariesFromForms(JsonArray summaries, Func2<String, String, JsonObject> summaryGatherer) {
    List<JsonObject> validSummaries = new LinkedList<>();
    summaries.stream()
            .map(JsonUtil::safeJsonObject)
            .filter(summary -> StringUtils.isNotEmpty(summary.getString(NAME)) || StringUtils.isNotEmpty(summary.getString(Form.TITLE)))
            .forEach(validSummaries::add);
    Set<String> visited = new HashSet<>();
    return Observable.from(validSummaries)
            .flatMap(summary -> {
                if (StringUtils.isNotEmpty(summary.getString(TEXT)))
                    Observable.from(gatherSummariesFromElement(summary.getString(Summary.SHORT_NAME), Summary.SummaryValues.FORM,
                            summary.getString(Summary.SHORT_NAME) + ".hidden",
                            summary.getString(VALUE), visited, summaryGatherer)));
                if (StringUtils.isNotEmpty(summary.getString(Form.TEXT)))
                    Observable.from(gatherSummariesFromElement(summary.getString(Summary.SHORT_NAME), Summary.SummaryValues.FORM,
                            summary.getString(Summary.SHORT_NAME) + ".title",
                            summary.getString(Summary.VALUE), summaryGatherer, visited,true)));
            })
            .toMap(summaryResult -> summaryResult.getString(KEY), summaryResult -> summaryResult.getJsonObject(TEXT));
}

private List<JsonObject> gatherSummariesFromElement(String parentName, String parentType, String elementName, String summaryValue, Func2<String, String, JsonObject> summaryGatherer, Set<String> visited, boolean isList) {
    if (visited.contains(elementName))
        return Collections.emptyList();
    visited.add(elementName);
    List<JsonObject> result = new ArrayList<>()

    Map<String, JsonObject> summariesMap = new HashMap<>();

    summariesMap.put(elementName, new JsonObject().put(Summary.SummaryValues.FORM, form).put(SUMMARY_TYPE, parentType));
    Set<String> variables = TextEngine.getVariables(summariesMap);

    result.add(getSummaryEntry(elementName, form, parentType, isList));

    if (variables != null && !variables.isEmpty()) {
        for (String variable : variables) {
            if (StringUtils.contains(variable, ".") && StringUtils.equals(parentName, StringUtils.split(variable, ".")[0])) {
                // do nothing
            } else {
                JsonObject variableEntry = summaryGatherer.call(parentName, variable)
                if (variableEntry != null) {
                    result.addAll(gatherSummariesFromElement(parentName, variableEntry.getString(SOURCE_TYPE), variable, variableEntry.getString(FORM), summaryGatherer, visited, variableEntry.getBoolean(Summary.SummaryValues.IS_LIST, false));
                }
            }
        }
    }
    return result;
}