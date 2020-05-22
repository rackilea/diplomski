Map<String, Double> sc = new HashMap<>();
String sql = "SELECT atr_name, AVG(newScore) AS avgScore FROM scores GROUP BY atr_name";
rs = statement.executeQuery(sql);

while (rs.next()) {
    sc.put(rs.getString("atr_name"), rs.getDouble("avgScore"));
}

sc.forEach((k, v) -> System.out.println("atr_name: " + k + ", average score: " + v));