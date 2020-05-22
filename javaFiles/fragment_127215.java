try {
    price = Double.parseDouble(strPrice);
    if (price < 0) {
        throw new CDException("Can't be negative");
    }
} catch (NumberFormatException ex) {
     ...
}