// The RowMapper for the table TIME_AND_EXPENSE_STAGING
// More columns than JOB_CODE exists but are not part of the example
private final RowMapper<TimeAndExpense> timeAndExpenseRowMapper = 
        (rs, rowNum) -> new TimeAndExpense(rs.getString("JOB_CODE"));

// The RowMapper for the table TIME_AND_EXPENSE_APPROVED
// Reuse the timeAndExpenseRowMapper's mapping, then add additional approval data
private final RowMapper<TimeAndExpense> timeAndExpenseApprovedRowMapper =
        (rs, rowNum) -> timeAndExpenseRowMapper
                .mapRow(rs, rowNum) // use the timeAndExpenseRowMapper
                .withApprovalData(  // and add the additional approval data
                        rs.getTimestamp("APPROVE_TIME"),
                        rs.getString("APPROVER_ID"));