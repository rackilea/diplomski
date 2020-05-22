...

public void updateRoles(AjaxBehaviorEvent event) {  
    //database is theobject in the current row 
    Database database = (Database) event.getComponent().getAttributes().get("selRec");       
}   
...