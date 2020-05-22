public void deleteComp(){
    session.beginTransaction();
    System.out.println("Enter Company ID to delete it");
    int cmp_id = compSc.nextInt();
    Companies company = session.get(Companies.class, cmp_id); 
    session.delete(company);        
    session.getTransaction().commit();
    return;
}