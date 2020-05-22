public ArrayList<ApprovalConditionBean> getAllApprovalCondition() {
    // ...
    connection = getConnection();
    // ...
}

Connection getConnection() {
    return AppsproConnection.getConnection();
}