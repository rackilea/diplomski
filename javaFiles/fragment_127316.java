@Override
protected Object determineCurrentLookupKey() {
if (RequestContextHolder.getRequestAttributes() == null) {
    return DEFAULT_ONE;
}
return db.getPreferredDb();
}