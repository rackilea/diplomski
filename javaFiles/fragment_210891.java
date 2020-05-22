String body = "You have bought USD 1.00 Whatsapp for 784024487. Your new wallet balance is USD 1.04. Happy Birthday EcoCash for turning 7years. Live Life the EcoCash Way.";
String regex = "(\\d+\\.\\d+).*(\\d+\\.\\d+)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(body);
while (matcher.find()) {
    System.out.println("First float: " + matcher.group(1) + ", Second float: " + matcher.group(2));
}