JCO.Function function = null;
Connection conn = new Connection();
JCO.Client mConnection = conn.open();
JCO.Table GET_DATA = null;
JCO.Repository mRepository;
mConnection.connect();

mRepository = new JCO.Repository("KEYWORD",mConnection);

try{
    function = this.createFunction("MY RFC NAME");
    if(function != null){

         GET_DATA = function.getTableParameterList.getTable(TABLE_NAME);
         GET_DATA.appendRow();

         function.getImportParameterList.setValue("ID1","USERID");
         function.getImportParameterList.setValue("Test Name","UNAME");
         function.getImportParameterList.setValue("CLASSA","UCLASS");

         GET_DATA.nextRow();
         mConnection.execute(function);
    }
}catch(Exception ex){
    // Exception handling goes here.
}
conn.disconnected();