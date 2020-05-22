Set<String> dmlCommands = new HashSet<String>() {
  {
    add("UPDATE"); add("INSERT"); add("DELETE"); //Add more DML commands ....
  }
};
int updateCount = statement.getUpdateCount();
for(String dml : dmlCommands) {
    if(arbitrarySQLCommand.toUpperCase().contains(dml) && updateCount == 0) {
        updateCount = -1;
        break;
    }
}