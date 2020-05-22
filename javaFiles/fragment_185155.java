String sql1="SELECT * from reg_courses WHERE regNo='"+reg+"' && day='"+students[j][4]+"' && start='"+rrr+"' LIMIT 1";

// In if block
String sql2="UPDATE attendances SET status='1' WHERE regNo='"+reg+"' && code='"+rs1.getString("code")+"' && time='"+rrr+"' && date='"+students[j][1]+"'";

// In else if block
String sql2="UPDATE attendances SET statusA='1', present='1' WHERE regNo='"+reg+"' && code='"+rs1.getString("code")+"' && time='"+rrr+"' && date='"+students[j][1]+"' && status='1'";