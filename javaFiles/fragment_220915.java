public ArrayList<String> jcbNames() {
    try {
        con = connCC.getDBconnection();
        stm = con.createStatement();
        ResultSet rs = stm.executeQuery("Select customerName From appointment");
        ArrayList<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}