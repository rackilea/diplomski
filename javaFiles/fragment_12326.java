JSONArray jsArray = dbcon.callSelectRecords("SELECT CODE, VALUE FROM M_SYSCONFIG WHERE MODULE = 'LIMIT_CONFIG' AND CODE in (?,?,?,?) ORDER BY VALUE", ft_other_cn, ft_own_account, payment, purchase);

for (int i = 0; i< jsArray.size(); i++) {
    JSONObject js = JSON.newJSONObject(jsArray.get(i).toString());
    String trasactionType = JSON.get(js, "CODE");
    String value = JSON.get(js, "VALUE");
    List<String> data = Arrays.asList(value.split(","));
    List<String> sortedData=sortData(data);  **<------**