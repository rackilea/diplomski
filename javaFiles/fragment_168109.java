List<Object[]> results = sess.createQuery(hqlSelectBook).list();

for (Object[] result : results) {
    String bookTitle = (String) result[0];
    String author = (String) result[1];
    

}