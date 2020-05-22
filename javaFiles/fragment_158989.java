public void Delete(ActionEvent event)
{
    try
    {
        Connection conn = SqliteConnection.Connector();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Studentlist WHERE ID = ?");
        StudentData studentdata = studenttable.getSelectionModel().getSelectedItem();
        ps.setString(1, studentdata.getID());

        ps.execute();
        conn.close();
    }
    catch (SQLException e)
    {
        System.out.println(e);
    }
}