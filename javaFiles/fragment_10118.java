SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
String fromDate = "11-07-2014";
Date fromDt = formatter.parse(fromDate);
String toDate = "11-07-2014";
Date toDt = formatter.parse(toDate);

String userInQuery = "from log where userName in (:userList) and systemdate between :fromDate and :toDate";
Query q = s.createQuery(userInQuery);
q.setParameterList("usersList", users);
q.setParameter("fromDate", fromDt);
q.setParameter("toDate", toDt);
q.list();