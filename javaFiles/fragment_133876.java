public static List<Account> filterObjects(List<Account> accountList) {
    for (Iterator<Account> iterator = accountList.iterator(); iterator.hasNext();) {
        Account account = iterator.next();
        if (account.getAccountName().startsWith("Z")) {
            iterator.remove();
        }
    }
}