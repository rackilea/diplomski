int i = 0;
for (Object id: someReallyBigIdList) {
    myEntity = find(id); 
    // do something basic with myEntity
    if ( i % 20 == 0 ) { //20, same as the JDBC batch size
        //flush a batch of DML operations and release memory:
        em.flush();
        em.clear();
    }
    i++;
}