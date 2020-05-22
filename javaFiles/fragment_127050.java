for (DataSnapshot journalDS : dataSnapshot.getChildren()) {
    Map<String, String> map = (Map<String, String>) journalDS.getValue();
    String journalName = map.get("journalName");
    String companyName = map.get("companyName");
    String journalColor = map.get("journalColor");
    String userID = map.get("userID");
    String journalID = map.get("journalID");
    Journal journal = new Journal(journalID, userID, journalName, companyName, journalColor);
    journalArrayList.add(journal);
}