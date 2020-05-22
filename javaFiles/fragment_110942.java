Session session = sessionFactory.openSession();
Query q = session.createQuery("from States");
List<String> list = (List<String>) q.list();

String listAsString = "";

for (String str : list) {
    listAsString += str + "\n";
}

return listAsString;