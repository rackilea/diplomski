int y = 0;
String vSQL1 = "select username from tblusermaster where usertype='engineer' and status='active'";
db.rs1 = db.GetRecordsetRS(vSQL1);

dataEngineer = new DefaultComboBoxModel();
try{

    while(db.rs1.next()){

        dataEngineer.addElement(db.rs1.getString("username"));

    }

}catch(SQLException err){

    err.printStackTrace();

}
cBoxEngineer.setModel(dataEngineer);