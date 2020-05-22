// define model 
public class Person extends Model {}

...

Base.open(...) // open default database
DB otherDB = new DB("other_database"); 
otherDB.open(...); // open other database

// read users from "other" database
List<Map> users = db.findAll("select first_name \"firstname\" from users");

// save people into default database
for(Map user: users){
   Person p = new Person(); 
   p.fromMap(user); 
   p.saveIt;
}

Base.close(); 
otherDb.close();