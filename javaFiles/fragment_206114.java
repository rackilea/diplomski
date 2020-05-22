private void load(String value) {
    Conector cc = new Conector();
    Connection cn = cc.conexion();

    String[] titles = {"Dates"};
    model = new DefaultTableModel(null, titles);
    String sql = "SELECT * FROM turns WHERE dates LIKE ?";

    try (PreparedStatement st = cn.prepareStatement(sql)) {
        st.setString(1, "%" + value + "%");
        try (ResultSet rs = st.executeQuery(sql)) {

            Object[] records = new Object[1];
            while (rs.next()) {
                records[0] = rs.getDate("mydate");
                model.addRow(records);
            }
            tablaturnos.setModel(model);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error:" + e, "Error Message", JOptionPane.ERROR_MESSAGE);
    }
}