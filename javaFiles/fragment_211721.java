String res = "INSERT INTO reservation(check_in_date,check_out_date,cus_id,room_no,Username,nights,adults,kids)" 
        + " VALUES (?,?,?,?,?,?,?,?)";
try (PreparedStatement stm=link.prepareStatement(res)) {
    stmt.setDate(1, startDate);
    // ... other variables

    // Option 1, assuming kids is an object (eg Integer)
    stm.setObject(7, kids);

    // Option 2, kids is int and other condition used to determine if null,
    // explicitly set null or set value:
    if (kidsIsNull) {
        stm.setNull(7, Types.INTEGER);
    } else {
        stm.setInt(7, kids);
    }
    stm.executeUpdate();
}