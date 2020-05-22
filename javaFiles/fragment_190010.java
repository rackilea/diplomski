ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
dateTeamCountMap.forEach((date, nestedMap) -> {
    Map<String, String> temp = new HashMap<String, String>();
    temp.put("Date",date);
    nestedMap.forEach((team, count) -> {
        temp.put(team,count);
    });
    list.add(temp);
});