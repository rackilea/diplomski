public String GetAuthCode(String number)
{
    String code = driver
            .findElement(
                    By.xpath("//tr/td[contains(.,'" + number + "')]/following-sibling::td[contains(.,'Your authentication code')]"))
            .getText();
    String regex = "Your authentication code is: (\\d+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(code);

    if (matcher.find())
    {
        return matcher.group(1);
    }

    return "";
}