element.sendKeys(generateRandomString());


 public String generateRandomString() {
    return "Selenium Beginners" + new BigInteger(120, new SecureRandom()).toString(32);
}