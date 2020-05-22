public void setDefaultMailAccount(MailAccount defaultMailAccount) {
    this.defaultMailAccount = defaultMailAccount;
    try {
        databasecontroller.update(this);
    } catch (FailedDatabaseOperationException e) {
        handleException(e, false, null, null);
    }
}