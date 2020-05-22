// untested
public List<Long> extractIdsFromJson(String json) {
    List<Long> list = new ArrayList<Long>();
    Matcher matcher = Pattern.compile("\"widget_id\":\"?(\\d+)\"?").matcher(json);
    while (matcher.find())
        list.add(Long.valueOf(matcher.group(1)));
    return list;
}