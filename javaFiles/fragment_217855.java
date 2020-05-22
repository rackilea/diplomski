while(rs.next())
{
    String d = rs.getString("className");
    String e = rs.getString("homeWork");
    String f = rs.getString("dueDate");
    model.addRow(new Object[]{d, e, f});
}