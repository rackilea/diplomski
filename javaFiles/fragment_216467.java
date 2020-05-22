private void fill(){
   try{
       con = DriverManager.getConnection("jdbc:....");
       Statement pst = con.createStatement();
       String sql = "select * from student";
       ResultSet rs = pst.executeQuery(sql);
       while(rs.next()){
        Student student = new Student(rs.getInt("student_id") , rs.getString("student_name"));     
         jCombo.addItem(student);
       } // while end

   } catch (Exception e){
      System.out.println(e.getMessage);
 }