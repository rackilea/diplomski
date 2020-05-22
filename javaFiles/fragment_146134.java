Session session = HibernateUtil.getSessionFactory().openSession();

int i = 0;
int batch = 5000; //process in batches if table is too big
Long rowCount = (Long) session.createQuery("select count(*) " + cacheDetail.getQuery()).list().get(0);

//Create a new list to sum each batch    
List<Object> total = new ArrayList<>();

System.out.println("Starting execution on " + cacheDetail.getQuery());
if (rowCount > batch) {
    List<Object> list = session.createQuery(cacheDetail.getQuery())
            .setFirstResult(i).setMaxResults(batch).list();
    total.addAll(list);

    while(list.size() == batch || list.size() < batch) {
        i+=batch;

        if (list.size() < batch) {
        list = session.createQuery(cacheDetail.getQuery())
                .setFirstResult(i).setMaxResults(list.size()).list();
        } else {
        list = session.createQuery(cacheDetail.getQuery())
                .setFirstResult(i).setMaxResults(batch).list(); 
        }

        total.addAll(list);//add to total
        //Do some computation, close session
    }
} else { //what if row count is less than batch, YOU DID NOT HANDLE
    List<Object> list = session.createQuery(cacheDetail.getQuery())
            .setFirstResult(i).setMaxResults(rowCount).list();
            total.addAll(list);
       //Do some computation, close session
}