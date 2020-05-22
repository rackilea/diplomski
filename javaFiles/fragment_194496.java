public void ejecutarScript(String file) throws IOException, SQLException {
    Statement st3 = conexion.createStatement();
    BufferedReader in = new BufferedReader(new FileReader(file));
    String str;
    StringBuffer sb = new StringBuffer();
    while ((str = in.readLine()) != null) {
        sb.append(str + "\n ");
    }
    in.close();
    st3.executeUpdate(sb.toString());
}