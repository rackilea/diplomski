if(rs != null) {
    while(rs.next()) {
        this.dbChoices[i] = rs.getString("DB_Type");
        i++;
    }
}