String[] items = selectedItem.split(" ");
  if(items.length >= 2){
    String sql ="Select matricule from employés where nom='"+items[0]+"' and prénom='"+items[1]+"'";
    ps=conn.prepareStatement(sql); 
    rs=ps.executeQuery();              
    if(rs.next()){
        jTextField1.setText(rs.getString("matricule"));
    } 
  }