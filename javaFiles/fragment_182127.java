try{
    transaction.begin();
    int count = session.createQuery("UPDATE GroupsDetails SET Name='" + Name + "', StartDate='" + startDate + "', EndDate='" + endDate + "', Status_GroupID=" + Status_GroupID + " WHERE GroupsID=" + GroupsID).executeUpdate();
    System.out.println("Number of records updated = " + count);
    transaction.comit();
  } catch(Exception ex){
    transaction.rollback();
    ex.printStacktrace();
}finally{
    session.close();
  }