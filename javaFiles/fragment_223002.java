StringBuilder q = new StringBuilder("select foo.* from Foo foo where 1 = 1");
List<String> parameters = new ArrayList<String>();
if (x != null) {
    q.append(" and foo.x = ?");
    parameters.add(x);
}
if (y != null) {
    q.append(" and foo.y = ?");
    parameters.add(y);
}

// ...
PreparedStatement stmt = connection.prepareStatement(q.toString());
int i = 1;
for (String arg : arguments) {
    stmt.setString(i, arg);
    i++;
}