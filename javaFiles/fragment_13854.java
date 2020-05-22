BudgetEntryItem entry = null;
for(int i = 0; i < budgetItems; i++){
    entry = budgetItems[i]; // or budgetItems.get(i), etc
    TableRow tr = new TableRow(this);

    // Set the index as the tag
    tr.setTag(i); // or entry.setTag(entry.index()), etc

    // ...
}