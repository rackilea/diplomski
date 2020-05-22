String query = "select * from foo f";
List<String> clauses = new ArrayList<String>();
List<Object> parameters = new ArrayList<Object>();

if (firstName != null) {
    clauses.add("f.name = ?");
    parameters.add(firstName);
}
// ...
if (!clauses.isEmpty()) {
    query += " where " + StringUtils.join(clauses, " and ");
}

PreparedStatement ps = connection.prepareStatement(query);
for (int i = 0; i < parameters.size(); i++) {
    ps.setObject(i + 1, paremeters.get(i));
}