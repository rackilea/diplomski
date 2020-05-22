for (Iterator<ExpenseList> iterate = uncategorizedList.iterator(); iterate.hasNext();) {
   for(int i=0; i < income.length; i++) {
        ExpenseList expense = iterate.next();
        if (expense.getDescription().toLowerCase().contains(income[i])) {
            incomeList.add(new ExpenseList(expense.getDate(),expense.getDescription(), expense.getPrice()));
            // Remove the current element from the iterator and the list.
            iterate.remove();
        }
    }
}