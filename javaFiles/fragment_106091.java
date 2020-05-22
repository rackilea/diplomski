BigDecimal total = BigDecimal.ZERO;
for (int i = 0; i < table.getRowCount(); ++i) {
    final BigDecimal amount = (BigDecimal)table.getValueAt(i, 6);
    total = total.add(amount);
}
totalSum.setText(total.toString());