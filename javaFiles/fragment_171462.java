Database db = new Database(); // open database
Database db2 = new Database(); // open another creepy one :/ 

int number  =  table.getModel().getValueAt(rows, 0);                            
ResultSet thisSet =  db.returnBill(number);
while (thisSet.next()){
        String name = thisSet.getString("name");
        int quantity = thisSet.getInt("quantity");
        // do something with the returned data 
        // --------> STUPIDO <----------
        //** Now executing an UPDATE query on db2 :
        // ex.: UPDATE anotherTable SET amount = (current+ "+ quantity+") WHERE name= '" + name+ "' ;";
}
db.closeConn(); // close db ++ 
db2.closeConn(); // closes db 2