public void deleteStudent(String id){
    System.out.println("Delete Called");
    sql = "DELETE FROM student WHERE student_id="+id;
    con = ConnectionManager.getConnection();
    try{
        stmt = con.createStatement();
        stmt.executeUpdate(sql);
    } catch (SQLException e){
        e.printStackTrace();
    }
}