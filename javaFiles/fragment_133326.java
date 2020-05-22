try ( Connection con = cpds2.getConnection() ) {
    for (Object itemId: aList.getItemIds()){
        boolean id_is_present = false;
        try ( PreparedStatement stmt = con.prepareStatement("select [ID] from [DB].[dbo].[Table1] WHERE [ID] = ?") ) {
            stmt.setInt(1, aList.getItem(itemId).getBean().getID());
            try ( ResultSet rs = stmt.executeQuery() ) {
               id_is_present = rs.next();
            }
        }
        if ( id_is_present ) {
            System.out.println("Duplicate");
            try ( PreparedStatement stmt = con.prepareStatement("UPDATE [DB].[dbo].[Table1] SET [DateSelected]=GETDATE() where  [ID] = ?") ) {
                stmt.setInt(1,aList.getItem(itemId).getBean().getID());
                stmt.executeUpdate();
            }
         } else {
             System.out.println("Insertion");
             try ( PreparedStatement stmt = con.prepareStatement("INSERT INTO [DB].[dbo].[Table1] ([ID],[FirstName], [LastName],[DateSelected]) VALUES (?,?,?,?)") ) {
                 stmt.setInt(1,aList.getItem(itemId).getBean().getID() );
                 stmt.setString(2,aList.getItem(itemId).getBean().getFirstName());
                 stmt.setString(3,aList.getItem(itemId).getBean().getLastName() );
                 stmt.setTimestamp(4, new Timestamp(new Date().getTime()));
                 stmt.executeUpdate();
             }
         }
    }
    Notification.show("Save Complete");    
}