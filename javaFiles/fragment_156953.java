List<Account> accountList = new ArrayList();
Account account;

while(rs.next()) {   

    account = new Account();
    account.setId(rs.getLong("Id"));
    account.setUserName(rs.getString("UserName"));
    account.setUserId(rs.getString("UserId"));
    account.setPassword(rs.getString("Password"));
    account.setStatus(rs.getBoolean("Status"));

    accountList.add(account);
}