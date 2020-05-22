String values = "INSERT INTO GROUPS " +
"(GROUP_NAME,ENTRY_NAME,ENTRY_TYPE,LAST_REQ,CREATE_BY,REQ_BY,LAST_CHANGED,LAST_REQ_TIME) " +
"VALUES (?,?,?,?,?,?,?,?)";

// ... 

statement = conn.prepareStatement(values);

// ... 

while(i < addedResources.size()){
   statement.setString(addedResources.get(i)).getGROUP_NAME().trim());
   statement.setString(addedResources.get(i)).getENTRY_NAME().trim());

   // ...  

   statement.addBatch();
}
statement.executeBatch();