BoxCategory.addItemListener(new ItemListener() {

    public void itemStateChanged(ItemEvent arg0) {
        //
        //
        String s = BoxCategory.getSelectedItem().toString();
        String sql = "Select * from Products where Category='" + s + "'";
        //
        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                // BoxDescription.removeAllItems();
                BoxCategory.setSelectedItem(rs.getString("Description"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
});