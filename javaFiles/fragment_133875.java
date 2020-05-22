public static List<Account> filterObjects(List<Account> accountList) {
    for(int i = 0; i < accountList.size(); i++) {
        if(accountList.get(i).getAccountName().startsWith("Z")) {
            accountList.remove(i);
            i--; // Just removed an element, so jump back one index.
        }
    }
    return accountList;
}