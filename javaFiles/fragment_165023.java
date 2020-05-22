String SQL = 
"SELECT A.* FROM \n" +
"(select * \n" +
" from user_history$ order by pwdDate desc limit 5 ) AS A \n" + 
"where pwd = AES_ENCRYPT(:pwd, 'key_str') \n";

Query query = session.createSQLQuery(SQL);
query.setParameter("pwd", psw);
List<UserHistory> list = query.list();