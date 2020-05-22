private boolean isAttribtuePresent(WebElement element, String attribute) {
    Boolean result = false;
    try {
        String value = element.getAttribute(attribute);
        if (value != null){
            result = true;
        }
    } catch (Exception e) {}

    return result;
}