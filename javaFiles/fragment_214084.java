List<String> dataTaskIDAdmin = new ArrayList<>(100);

try{

    while(db.rs.next()){

        dataTaskIDAdmin.add(db.rs.getString("taskid"));

    }

}catch(SQLException e){

    e.printStackTrace();

}

cBoxTaskID = new JComboBox(dataTaskIDAdmin.toArray(new String[dataTaskIDAdmin.size()]));