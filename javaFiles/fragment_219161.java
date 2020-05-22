try 
    {    
        ////here most add rs.first();
        Gson conv = new Gson();
        String status        = rs.getString(fieldOne);
        String comment       = rs.getString(fieldTwo);

    String rep = conv.toJson(new StatusForm(status, comment ));
    this.statusAsJSON = rep;
} catch (SQLException ex) {
    Logger.getLogger(GetStatusFromDB.class.getName()).log(Level.SEVERE, null, ex);
}