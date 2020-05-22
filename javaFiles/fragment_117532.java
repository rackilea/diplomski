public static void main(String[] args) {

    DecimalFormat df = new DecimalFormat("#.00");
    DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
    sym.setDecimalSeparator(',');
    df.setDecimalFormatSymbols(sym);

    Pizza Rentals = new Pizza("Rentals", 4.10);
    Pizza Strength = new Pizza("Strength ", 3.10);
    Pizza Molissimo = new Pizza("Molissimo", 4.20);

    System.out.println(Rentals.getName() + " (" + df.format(Rentals.getPrice()) + " euros)");
    System.out.println(Strength.getName() + " (" + df.format(Strength.getPrice()) + " euros)");
    System.out.println(Molissimo.getName() + " (" + df.format(Molissimo.getPrice()) + " euros)");
}