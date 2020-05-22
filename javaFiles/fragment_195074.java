username="'; or 1=1";
sane_username=StringEscapeUtils.escapeSql(username);
// turns into "''; or 1=1"

sql= "select username from users where username = '" + sane_username + "'";
// select username from users where username = '''; 1 or 1'