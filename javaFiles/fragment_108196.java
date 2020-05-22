String sqlStatement = "SELECT "
            + DBStrings.C_VH_ID
            + " FROM " + DBStrings.CUSTOMER + " WHERE " + DBStrings.C_ID + " = " + customerId;
    rs = statement.executeQuery(sqlStatement);
    if (rs != null && rs.next()) {
        int vh_id = rs.getInt(DBStrings.C_VH_ID);
        vehicle = this.getVehicleFromId(vh_id);
    }