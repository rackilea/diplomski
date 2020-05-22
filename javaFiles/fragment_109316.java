private void btnLoadActionPerformed(java.awt.event.ActionEvent evt)
{
    DefaultTableModel dtm = (DefaultTableModel) tblAllMovies.getModel();
    dtm.addRow( new Object[]{new Integer(1), "movieName1" , "movieGenre1", "movieTime1"} );
    dtm.addRow( new Object[]{new Integer(2), "movieName2" , "movieGenre2", "movieTime2"} );
    dtm.addRow( new Object[]{new Integer(3), "movieName3" , "movieGenre3", "movieTime3"} );
    dtm.addRow( new Object[]{new Integer(4), "movieName4" , "movieGenre4", "movieTime4"} );
}