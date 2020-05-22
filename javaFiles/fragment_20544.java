Object around(DBRow dbRow) : get(@InDB * DBRow+.*) && target(dbRow) {
    Object value = proceed(dbRow);
    System.out.println(thisJoinPoint);
    System.out.println("  " + dbRow + " -> " + value);
    dbRow.load();
    return value;
}