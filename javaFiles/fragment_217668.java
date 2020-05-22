int counter = 0;
String prevDate = "";
for (int i = 0; arrayList.size(); i++) {
    long timestamp = Long.parseLong(arrayList.get(i));
    Date time = new Date(timeStamp * 1000L);
    String date = String.valueOf(time.getDate());
    if (date.equals(prevDate)) {
        ++counter;
    } else {
        counter = 1;
        prevDate = date;
    }
    // Do something useful with the counter
}