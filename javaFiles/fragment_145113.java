try (Statement stmt = con.createStatement()) {
    try (ResultSet rs = stmt.executeQuery("select exists(select 1 from calcul where to_char(date, 'YYYY-MM')=to_char("+dates+", 'YYYY-MM') AND idproduit="+codeP+" AND ppa="+PPA+" AND tr="+TR+" AND net="+NET+" AND dateper='"+datePer+"')")) {
        if (rs.next()) {
            boolean exists = rs.getBoolean(1);
        }
    }
} catch (SQLException exp) {
    exp.printStackTrace();
}