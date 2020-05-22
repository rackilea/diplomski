private MySQLConnection sqlConn ;

public Screen(MySQLConnection sqlConn){
    ...
    this.sqlConn = sqlConn;
    String mainId = mainI.getText();
    String mainName = mainN.getText();
    mainValues.add(mainId);
    mainValues.add(mainName);
}

public void saveToDatabase() {
    String[] mainColumns= {"mid", "mname"};
    sqlConn.addToDatabase("main_category", mainColumns, mainValues);
}