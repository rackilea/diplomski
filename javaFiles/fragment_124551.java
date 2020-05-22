PrintWriter out = response.getWriter();
StringBuffer res = new StringBuffer();
while (rs.next()) {
    String location = rs.getString(2);
    String track = rs.getString(1);
    String myDate = rs.getString(3);
    res.append("{");
    res.append("'location':");
    res.append(location);
    res.append(",");
    res.append("'track':");
    res.append(track);
    res.append(",");
    res.append("'myDate ':");
    res.append("myDate ");
    res.append("}");
}
out.println(res.toString());