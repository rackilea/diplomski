@Override
public void delete(int id) {
    Account accounts = new Accounts();
    // hibernate deletes objects by the primary key
    accounts.setId(id);
    getCurrentSession().delete(accounts);
}