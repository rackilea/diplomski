private void btYesActionPerformed(java.awt.event.ActionEvent evt) {                                     
    Connection conn = connectionClass.GetConnections();
    boolean done = false;
    PreparedStatement pst;
    ResultSet rs;
    String task;
    task = "T26"; // Set initial value of task
    // Assuming one row expected (may want to handle error case later)
    query = "SELECT * FROM task WHERE ID = ? LIMIT 1"

    try {
        pst = conn.prepareStatement(query);

        while (!done) {
            pst.setString(1, task)
            rs = pst.executeQuery()
            while (rs.next()) {
                String TEXT = rs.getString("TEXT");
                String IF_YES = rs.getString("IF_YES");
                labelTEXT.setText(TEXT);
                task = IF_YES; // Task is now updated for the next loop
            }
            // TODO: Make sure to set done to false when all tasks complete.
        }

        pst.close()
        conn.close()
    } catch (Exception e) {
    }
}