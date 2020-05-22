public void handleUpdateAction(ActionEvent event) {
    String sql = "update users set name =?, age = ?, department=?, job=?,  contact = ? where userNo =?" ;
    try {

        String userNo = txt_userNo.getText();
        String name = txt_name.getText();
        double age = Double.valueOf(txt_age.getText());
        String department = txt_department.getText();
        String job = txt_job.getText();
        String contact = txt_contact.getText();
        p_stmt = con.prepareStatement(sql);

        p_stmt.setString(1, name);
        p_stmt.setDouble(2, age);
        p_stmt.setString(3, department);
        p_stmt.setString(4, job);
        p_stmt.setString(5, contact);
        p_stmt.setString(6, userNo);

        int i = p_stmt.executeUpdate();
        if (i == 1)  {
        }System.out.println("Data Updated Successfully");
        loadDataFromDatabase();

    }catch (Exception e) {
        e.printStackTrace();
        throw e;
    }
}