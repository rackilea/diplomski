for (int i = 0; i < aNodes.getLength(); i += COLS_PER_ROW) {
    account = new Account();
    String account = aNodes.item(i).getNodeValue();
    account.setAccount(account);
    String balance = aNodes.item(i+1).getNodeValue();
    account.setBalance(balance);
    String date = aNodes.item(i+2).getNodeValue();
    account.setDate(date);
    mAccounts.add(account);
}