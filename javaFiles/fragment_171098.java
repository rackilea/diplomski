public List<Map<String, Object>> getStatesCount(Date fromDate,
            Date toDate, String state, String xAxis) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("fromdate", fromDate);
    params.put("todate", toDate);
    params.put("state", state);
    params.put("xaxis", "yyyy-mm-dd");
    List<Map<String, Object>> sqlResults = (List<Map<String, Object>>) template.selectList(SELECT_COUNT, params);
    return sqlResults;
}