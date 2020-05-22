boolean isNumber = false;
try {
    Integer.parseInt(input);
    isNumber = true;
} catch(NumberFormatException e) {
    e.printStackTrace();
}