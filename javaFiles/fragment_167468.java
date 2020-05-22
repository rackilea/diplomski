private List<ContactActivity.Contact> transformListFromDB(List<dto.Contact> listFromDb) {
    List<ContactActivity.Contact> result = new ArrayList<ContactActivity.Contact>();
    for (dto.Contact con : listFromDb) {
         result.add(new ContactActivity.Contact(con.firstName, con.lastName); 
    }
    return result;
}