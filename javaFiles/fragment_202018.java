boolean result = false;
if (table.length() >= 4) {
    int length = table.length();
    result = table.substring(length - 4, length).equals("table");
}
return result;