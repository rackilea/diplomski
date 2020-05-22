Connection conn = null; 
Context ctx = new InitialContext();
DataSource ds = (DatSource)ctx.lookup("java:com/env"+userInput.getDB());

if(ds != null)
{
    conn = ds.getConnection();
}