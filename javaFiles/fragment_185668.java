private static void shuffle() {
    List<String[][]> banks = new ArrayList<>();
    for (String[][] bank : questionBanks) {
        List<String[]> shuffledBankRows = new ArrayList<>();
        for (String[] bankRow : bank) {
            shuffledBankRows.add(new QuestionBankRow(bankRow).getShuffledBankRow()); 
        }
        Collections.shuffle(shuffledBankRows);
        banks.add(shuffledBankRows.toArray(new String[0][0]));
    }
    // if you don't want to shuffle the banks around, don't perform
    // this shuffle
    Collections.shuffle(banks);
    questionBanks = banks.toArray(new String[0][0][0]);
}