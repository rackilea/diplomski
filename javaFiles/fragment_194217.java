private Session mysession = null;

public Dao(Session mysession) {
    this.mysession = mysession;
}

public void save(List<? extends Object> dataList) {  
    for (Object dataItem : dataList) {  
        save(dataItem);
    }  
}  

public void save(Object dataItem) { 
    try  { 
        Transaction tx = session.beginTransaction();  
        this.mysession.save(dataItem);  
        tx.commit();  
    }  
    catch(Exception e) {....}
}