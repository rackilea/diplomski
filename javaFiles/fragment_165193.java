public Double getValuPrice(int param1, int param2){
    Query query = session.createQuery("FROM TableClass WHERE product= :param1 and type = :param2");
    query.setParameter("param1",param1);
    query.setParameter("param2",param2);
    // assuming result is a field with type TableClass    
    result = (TableClass)query.uniqueResult();
    List lista = query.list();

    return lista; // <-- fix the return statement
}