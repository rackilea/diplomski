String width = "";
String height = "";
while(rs.next()){
    width = rs.getString(1);
    height = rs.getString(2).replace("'", ",");
}