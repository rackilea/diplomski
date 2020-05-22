DecimalFormat df = new DecimalFormat();
for (int i = 0; i < 4; i++) {
    df.setMaximumFractionDigits(i);
    df.setMinimumFractionDigits(i);
    System.out.println("example " + df.format(24) + " " + df.format(12.3456));
}