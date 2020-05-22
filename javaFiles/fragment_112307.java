PrintWriter out = null;
try {
    out = new PrintWriter(new FileWriter(fileName));
    for(int i = 0; i<writeList.size(); i++) {   
        if(writeList.get(i) instanceof Expense) {
            Expense writeExpense = (Expense) writeList.get(i);

            dump(out, writeExpense);
    }
 } finally {
 }