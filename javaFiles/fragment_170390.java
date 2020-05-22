public static String generateFormatPrice(double price) {
    final NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMANY);
    format.setMinimumFractionDigits(2);
    format.setMaximumFractionDigits(2);
    return format.format(price);
}