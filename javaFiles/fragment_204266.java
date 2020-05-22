public Record[] getRecord(String userName, String param1, BiFunction<User, MyObject, Record[]> method) throws MyException {
    User user = getUser(String username); // Always the same
    MyObject myObj = getMyObject(param1); // Always the same

    Record[] recs = method.apply(user, myObj);

    // Handle those records always the same ...
    handleRecords(recs); // Always the same
    return recs;  // Always the same
}