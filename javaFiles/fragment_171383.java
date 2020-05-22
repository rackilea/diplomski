donator a = new donator();
while(scanRecord.hasNextLine()) {
    String line = scanRecord.nextLine();
    if (!line.isBlank()) {
        ...
    } else {
        donatorList.addDonator(a);
        a = new donator();
    }