Matcher m = Pattern.compile("[A-Z][A-Z]([A-Z]|\\d)\\d\\d").matcher(bilnumer);
if (m.find()) {
    System.out.println(bilnumer + " is a valid number plate");
} else {
    System.out.println(bilnumer + " is not a valid number plate");
}