String strObjID="OBJ00015";
String strContent="asdasdasdas<asdasd>adasdasdasdsadsad";

PreparedStatement pstmt = con.prepareStatement("INSERT INTO TMP_FILE2(ID,FILECONTENT) values(?,EMPTY_CLOB())");
pstmt.setString(1,strObjID);
//pstmt.setClob(2, clob);
pstmt.executeUpdate();
pstmt.close();

//updating CLOB column with String value
Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
String query="Select FILECONTENT FROM TMP_FILE2 where ID=0001 FOR UPDATE";
con.setAutoCommit(false);
ResultSet resultset=stmt.executeQuery(query);

if(resultset.next()){
    oracle.sql.CLOB    clobnew = ((oracle.jdbc.OracleResultSet) resultset).getCLOB("FILECONTENT");

    byte[] bytes = strContent.getBytes();
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
    InputStreamReader isr = new InputStreamReader(bais);
    PrintWriter pw = new PrintWriter(clobnew.getCharacterOutputStream() );

    BufferedReader br = new BufferedReader(isr);
    //new FileReader( new File("D:\\test.txt") ) );
    String  lineIn = null;
    while( ( lineIn = br.readLine() ) != null )
      pw.println( lineIn );
      pw.close();
      br.close();
}
con.setAutoCommit(true);
con.commit();