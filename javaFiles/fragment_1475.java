Statement stm = con.createStatement();
ResultSet rs = stm.executeQuery("select pass from admin where nama='admin'");

while (rs.next()) {
    String n = rs.getString(1);

    if (n.equalsIgnoreCase(nama)) {
        Pegawai.setEnabled(true);
        InputCuti.setEnabled(true);
        DataCuti.setEnabled(true);
        DataCuti1.setEnabled(true);

        break; //when n==nama loop stops
    } else {
        Pegawai.setEnabled(false);
        InputCuti.setEnabled(false);
        DataCuti.setEnabled(true);
        DataCuti1.setEnabled(true);
    }

}