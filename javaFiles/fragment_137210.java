ResultSet rs = stmt.executeQuery( "SELECT * FROM crud_records order by id desc" );      
        while ( rs.next() ) {
           int id               = rs.getInt("id");
           String idStr         = Integer.toString(id);
           String  username     = rs.getString("username");               
           String  email        = rs.getString("email");
           String  password     = rs.getString("password");
           String  dateAdded    = rs.getString("dateAdded");                
           listingFrame.add(new JLabel(idStr));
           listingFrame.add(new JLabel(username));
           listingFrame.add(new JLabel(email));
           listingFrame.add(new JLabel(password));
           listingFrame.add(new JLabel(dateAdded)); 
           JButton specificDeleteBtn = new JButton("Delete "+idStr);
           specificDeleteBtn.setActinCommand(idStr);
           specificDeleteBtn.setActionListener(this);
           listingFrame.add(specificDeleteBtn);                  
        }
...
void actionPerformed(ActionEvent e) {
    String idStr = e.getActionCommand();
    // then you have the idStr of the item you want to remove...
}