public GenericDAO getDAO(Table t) throws SQLException 
{

    try
    {
        if(this.con == null || this.con.isClosed()) //Let's ensure our connection is open   
            this.open();
    }
    catch(SQLException e){ throw e; }

    switch(t)
    {
    case FIRST:
        return new FirstDAO(this.con);
    case SECOND:
        return new SecondDAO(this.con);
    default:
        throw new SQLException("Trying to link to an unexistant table.");
    }

}