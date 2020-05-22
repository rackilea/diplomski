DefaultComboBoxModel model = new DefaultComboBoxModel();

try{

    while(db.rs.next()){

        model.addElement(db.rs.getString("taskid"));

    }

}catch(SQLException e){

    e.printStackTrace();

}

cBoxTaskID = new JComboBox(model);