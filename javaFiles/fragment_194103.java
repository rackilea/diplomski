protected PreparedStatementSetter newArgPreparedStatementSetter(Object[] args) {
    Object[] converted = new Object[args.length];
    for (int i = 0; i < args.length; i++) {
        Object arg = args[i];
        if (arg instanceof DateTime) {
            converted[i] = ((DateTime) arg).toDate();
        } else {
            converted[i] = arg;
        }
    }
    return super.newArgPreparedStatementSetter(converted);
}