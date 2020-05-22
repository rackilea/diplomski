void update(EntityName entity){
    session.evict(entity);
    Query update = session.createSQLQuery(
          "update table_name "
        + "set c1 = ?,"
        +     "c2 = ? "
        + "where A = ? "
        + "and B = ? "
        + "and C is null" //this was the line that was needing to be added
    );

    //set the parameter values

    if(update.executeUpdate() == 0){
        session.save(entity);
    }
}