Vector<String> sections = new Vector<>();
try (Connection conn = DriverManager.getConnection(...);
        PreparedStatement pst = conn.prepareStatement("SELECT section FROM sections");
        ResultSet rs = pst.executeQuery()) {
    while(rs.next()) {
        String s = rs.getString(1);  
        sections.add(s);  
    }
} 
d11.setModel(new DefaultComboBoxModel(sections));
d12.setModel(new DefaultComboBoxModel(sections));
d13.setModel(new DefaultComboBoxModel(sections));
...