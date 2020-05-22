String price;
if (values[3].startsWith("EUR ") || values[3].endsWith(" €")) {
    // ignore non-digits and non-commas, and replace commas with dots
    price = values[3].replaceAll("[^\\d,]", "").replaceAll(",", ".");
} else {
    // ignore non-digits and non-dots
    price = values[3].replaceAll("[^\\d.]", "");
}