String query = "INSERT INTO bar VALUES ARRAY[";
String del = "";
for (int i = 0; i < 10; i++) {
    query += del+"?" ;
    del = ",";
}
query += "]";
System.out.println(query);