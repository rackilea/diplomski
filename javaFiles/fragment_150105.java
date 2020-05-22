DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("d");
ZoneId zone = ZoneId.of("Asia/Jakarta");
LocalDate date = LocalDate.now(zone);
int amount = 1;
int buttonCount = 7;
for (int i = 0; i < buttonCount; i++){
    int buttonId = getResources().getIdentifier("hari_" + (i + 1), "id", getPackageName()); 
    Button button = (Button) findViewById(buttonId);
    button.setHint(date.format(dateFormater));
    date = date.plusDays(amount);
}