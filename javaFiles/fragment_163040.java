private void configureTableParameters(JCoParameterList tableParameters){
    JCoTable jCoTable=tableParameters.getTable(key);
    jCoTable.appendRow();
    if(value!=null)
    jCoTable.setValue(fieldKey,String.valueOf(value));

}