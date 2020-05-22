Iterator<String> iUserName = idvEUserName.iterator();
Iterator<String> iFullName = idvEFullName.iterator();
Iterator<String> iUserType = idvEUserType.iterator();

while(iUserName.hasNext() && iFullName.hasNext() && iUserType.hasNext()) {
    insert.setString(1, iUserName.next());
    insert.setString(2, iFullName.next());
    insert.setString(3, iUserType.next());
    insert.addBatch(); 
}
insert.executeUpdate();