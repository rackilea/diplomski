private void formWindowOpened(java.awt.event.WindowEvent evt) {  
    try {   
        int p_id = made_up.p_id;  
        String sql = "SELECT * FROM pos_metrics WHERE p_id='" + p_id + "'";  
        ResultSet rs = mysql_query.execute_mysql(variables.con.conn, sql);  
        int i = 1;  
        while (rs.next()) {  
            String metricss = "metrics1" + i;  
            String metricss2 = "metrics2_" + i;  
            String values = "value" + i;  

            JTextField text1;  
            JTextField text2;  
            JTextField text3;  

            text1.setName(metricss);
            text2.setName(metricss2);  
            text3.setName(values);  

            text1.setText(rs.getString("pos_metrics1"));  
            text2.setText(rs.getString("pos_metrics2"));  
            text3.setText(rs.getString("pos_value"));  
            i++;  
         }  
    } catch (SQLException ex) {  
        Logger.getLogger(unit_builder.class.getName()).log(Level.SEVERE, null, ex);  
    }  
}