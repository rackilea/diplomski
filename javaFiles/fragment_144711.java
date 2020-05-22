@Test
void test() {
    Account wrongAcc = new Account("ABC", Collections.emptyList());
    Account goodAcc = new Account("DEF", Arrays.asList(
            new Balance("A", "10"),
            new Balance("A", "10"),
            new Balance("B", "20")
    ));
    Account wrongBalanceAcc = new Account("DEF", Arrays.asList(
            new Balance("A", "10"),
            new Balance("A", "20"),
            new Balance("B", "20")
    ));

    List<Account> accountList = Arrays.asList(wrongAcc, goodAcc, wrongBalanceAcc);

    assertThat(accountList)
            .filteredOn(acc -> acc.getId().equals("DEF"))
            .filteredOn(acc ->
                    acc.getBalances()
                            .stream()
                            .noneMatch(balance -> balance.getType().equals("A") && !balance.getAmount().equals("10"))
            ).containsExactly(goodAcc);
}