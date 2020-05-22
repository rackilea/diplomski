try (PreparedStatement stmt = con.prepareStatement("select exists(select 1 from calcul where to_char(date, 'YYYY-MM')=to_char(?, 'YYYY-MM') AND idproduit=? AND ppa=? AND tr=? AND net=? AND dateper='?')")) {
    stmt.setString(1, dates);
    stmt.setString(2, codeP);
    stmt.setString(3, PPA);
    stmt.setString(4, TR);
    stmt.setString(5, NET);
    stmt.setString(6, datePer);
    try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
            boolean exists = rs.getBoolean(1);
        }
    }
} catch (SQLException exp) {
    exp.printStackTrace();
}