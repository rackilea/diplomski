@Given("the numbers: $numbersTable")
public void theNumbers(ExamplesTable numbersTable) {

    List numbers = new ArrayList();
    for (Map<String,String> row : numbersTable.getRows()) {
        String combination = row.get("combinations");
        numbers.add(combination);
    }
}