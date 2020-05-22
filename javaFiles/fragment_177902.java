ResultSet rs = st.execute();   //Assuming that you have the resultset

Set<String> id = new LinkedHashSet<String>();
Set<String> body = new LinkedHashSet<String>();
Set<String> tag_name = new LinkedHashSet<String>();
Set<String> answer = new LinkedHashSet<String>();

while(rs.next())
{
    id.add(rs.getString("id"));
    body.add(rs.getString("body"));
    tag_name.add(rs.getString("tag_name"));
    answer.add(rs.getString("answer"));
}