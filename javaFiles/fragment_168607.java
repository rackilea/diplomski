private static String formatPrice(int price) {
  if (price < 0) {
    return "";
  }
  if (price > 1000 * 1000) {
    return String.format("(%.1fm)", ((double) price) / (1000 * 1000));
  } else if (price > 1000) {
    return String.format("(%dk)", price / 1000);
  }
  return String.format("(%dgp)", price);
}