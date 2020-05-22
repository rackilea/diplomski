StringBuilder buffer = new StringBuilder();
boolean processedFirst = false;
String firstParam = null, secondParam = null;

try{
    for(String record: arrayList1){
        if(processedFirst)
            buffer.append(",");
        buffer.append(record);
        processedFirst = true;
    }
    firstParam = buffer.toString();
}finally{
    buffer = null;
}
processedFirst = false;
buffer = new StringBuilder();
try{
    for(String record: arrayList2){
        if(processedFirst)
            buffer.append(",");
        buffer.append(record);
        processedFirst = true;
    }
    secondParam = buffer.toString();
}finally{
    buffer = null;
}
secondParam = buffer.toString();

String sql = "INSERT INTO soundsdata.splog (arraylist1, arraylist2) VALUES(?,?)";
try{
    psmt = (PreparedStatement) con.prepareStatement(sql);
    pstmt.setString(1,firstParam);
    pstmt.setString(2,secondParam);
    pstmt.executeUpdate();
}finally {
    pstmt.close();
}