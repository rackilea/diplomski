int numRow = dtm.getRowCount();
int columnAmount = 3; // TODO Set this to the correct column.
double totalAmount = 0.0;
for (int i = 0; i < numRow; i++) { // Loop over all rows
    // Add the value from column 'amount' to the total:
    totalAmount += Double.parseDouble(tblOrder.getValueAt(i, columnAmount).toString());
}

// TODO Do something with totalAmount
System.out.println(totalAmount);