String result = "";
while(rs.next()) {
    if(result.isEmpty()) result = rs.getString("nev");
    else result = result + "/" + rs.getString("nev");
}
arlab1.setText(result);