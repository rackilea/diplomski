class Account {
    ..
    public Condition byKey(Long accountId) {
        return ID.eq(accountId);
    }
    public AccountRecord fetchByKey(DSLContext ctx, Long accountId) {
        return ctx.fetchSingle(this, byKey(accountId));
    }
}