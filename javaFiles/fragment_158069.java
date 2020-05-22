String query = "UPDATE tbl_customer_policies SET "+
        "start_date = sysdate," + // or "start_date = ADD_MONTHS(SYSDATE, 12),"
        "next_pay_date = ?,"+
        "maturity_date = ?, " + 
        "modified_at = CURRENT_TIMESTAMP,"+
        "modifier = ?, status = ? " + 
        "WHERE id = ?";