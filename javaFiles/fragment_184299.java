List<LinkedCaseInsensitiveMap<String>> l_lstResult = service.fetchRowwiseMultipleRecords(p_iQueryName, l_hmParams, userDetails);

l_lstCityTownList = new ArrayList<String>(l_lstResult.size());

for (int i = 0; i < l_lstResult.size(); i++) {
    LinkedCaseInsensitiveMap<String> l_hmColmnData = l_lstResult.get(i);
    String l_sValue = l_hmColmnData.get(p_sColumnName);
    l_lstCityTownList.add(l_sValue);
}