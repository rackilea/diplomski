public void execute(PreparedStatement statement, String query) throws SQLException
{
    synchronized(this){
        activeQuery = statement;
        this.notify();
    }
}