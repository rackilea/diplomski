if (!message.startsWith("PABUSOG")) {
    return;
}

Pattern pattern = Pattern.compile("([A-Z_]+)[/,]([0-9])+", Pattern.CASE_INSENSITIVE);

Matcher m = pattern.matcher(message);
while (m.find()) {
    String food = m.group(1);
    String quantity = m.group(2);

    System.out.println(food + " -- " + quantity);
}