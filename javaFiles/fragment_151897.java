final Collection<Integer> ids = Arrays.asList(4, 5, 6);

final StringBuilder updatequery = new StringBuilder("Update articles SET Title = ? WHERE id IN (");

for (int i = 0; i < ids.size(); i++) {
    updatequery.append("?,");
}

updatequery.deleteCharAt(updatequery.length() - 1);
updatequery.append(")");

System.out.println(updatequery);

prestatement.setString(1, "Test");
int i = 2;
for (final Integer id : ids) {
    prestatement.setInt(i ++, id);
}