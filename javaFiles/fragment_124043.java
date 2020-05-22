private double getTotalMilk() {
    double quantity = Double.parseDouble(qtymilk.getText().toString());
    double amount = Double.parseDouble(milk.getText().toString());
    return quantity * amount;
}

private double getTotalTide() {
    double quantity = Double.parseDouble(qtytide.getText().toString());
    double amount = Double.parseDouble(tide.getText().toString());
    return quantity * amount;
}

@Override
public void onClick(View v) {
    if (v.getId() == R.id.button1) {
        double grandTotal = 0;

        double totalMilk = getTotalMilk();
        grandTotal += totalMilk;
        totalmilk.setText(Double.toString(totalMilk));

        double totalTide = getTotalTide();
        grandTotal += totalTide;
        totaltide.setText(Double.toString(totalTide));

        // Repeat pattern....

        grandtotal.setText(Double.toString(grandTotal));
    }
}