tmp_id = ""; 
Writer out = null;
while (resultset.next()) {
    if(resultset.getString("ID")!=tmp_id){ 
        if(out != null) {
          out.close();
        }
        //create new xml file
        out = new FileWriter(...);
        tmp_id =  resultset.getString("ID");
    }
    write the remain data corresponding to same id 
}
if(out != null) {
  out.close();
}