insertion_function(){
   //insert into your database
   //call your method which get max and show you the result
   set_max_function();
}

set_max_function() {
    textField = new JTextField();
    try {
        String query = "Select max(`Enquiry No`) as max from enquiry ";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int num = rs.getInt(1);
            int inc = num + 1;
            textField.setText(valueOf(inc));
        }
    } catch (Exception f) {
        f.printStackTrace();
    }
}