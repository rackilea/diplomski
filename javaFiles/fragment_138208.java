String queryString =
    EnumLinkFields.CREATE_TIME.getFieldName() + ":(>=" + dateFrom + " AND <=" + dateTo + ")";

QueryBuilder query = QueryBuilders.queryStringQuery(queryString);

String codeUrlOrContent = "if (" + EnumElasticScriptField.URL_OR_CONTENT.getFieldName() + ".length() > 50) {" +
        "return " + EnumElasticScriptField.URL_OR_CONTENT.getFieldName() + ".substring(0, 50);" +
        "} else { " +
        "return " + EnumElasticScriptField.URL_OR_CONTENT.getFieldName() + "; }";

Script scriptUrlOrContent = new Script(ScriptType.INLINE, "painless",
        codeUrlOrContent, Collections.emptyMap());

Script scriptIsUrl = new Script(ScriptType.INLINE, "painless",
        EnumElasticScriptField.IS_URL.getFieldName(), Collections.emptyMap());

SearchResponse response = TRANSPORT_CLIENT.prepareSearch(MY_INDEX)
                .setTypes(MY_TYPE)
                .setSearchType(SEARCH_TYPE)
                .setQuery(query)
                .addScriptField(EnumLinkFields.URL_OR_CONTENT.getFieldName(), 
                     scriptUrlOrContent)
                .addScriptField(EnumLinkFields.IS_URL.getFieldName(), scriptIsUrl)
                .setFrom(offset)
                .setSize(count)
                .addSort(orderByField, sortOrder)
                .execute().actionGet();