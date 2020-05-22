class AccountComparator implements Comparator<BankAccount> {

    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getName().compareTo(o2.getName());
    }

}