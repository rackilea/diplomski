public ActionForward
       execute(ActionMapping mapping,
               ActionForm form,
               HttpServletRequest request,
               HttpServletResponse response) throws Exception
{
 javax.sql.DataSource dataSource;
 java.sql.Connection myConnection;
 try {
  dataSource = getDataSource(request);
  myConnection = dataSource.getConnection();
  // do what you wish with myConnection
 } catch (SQLException sqle) {
    getServlet().log("Connection.process", sqle);
 } finally {
    //enclose this in a finally block to make
    //sure the connection is closed
    try {
       myConnection.close();
    } catch (SQLException e) {
       getServlet().log("Connection.close", e);
    }
   }
}