int result;
try {
    result = Integer.parseInt(someString);
} catch (NumberFormatException e) {
    result = 0;
}