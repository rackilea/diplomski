String query = "INSERT INTO student (age,name) VALUES (?,?)";
conn.setAutoCommit(true);  
ps = conn.prepareStatement(query);            
for (Student student:list) {
    ps.setInt(1, student.getAge());
    ps.setString(2, student.getName());
    ps.addBatch(); // <--
}
int[]temp=ps.executeBatch();
System.out.println("TEMP:"+temp.length);