public String generateColor(String redVal, String blueVal, String greenVal, String alphaVal) {
    StringBuilder theColor = new StringBuilder("0x")
            .append(alphaVal)
            .append(redVal)
            .append(greenVal)
            .append(blueVal);
    return theColor.toString();
}