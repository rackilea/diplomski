Map<String, List<String>> results = new HashMap<String, List<String>>();
while (rs.next()) {
    String url = rs.getString(1);
    String phone = rs.getString(2);
    List<String> phones = (results.contains(url) ? results.get(url) : new ArrayList<String>());
    phones.add(phone);
    results.put(url, phones);
}