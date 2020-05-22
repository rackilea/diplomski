if (equalsWithYesterday(items.get(i).date)){
    ...
}
...
public boolean equalsWithYesterday(Timestamp st){
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Time part has discarded
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    Date yesterday = dateFormat.parse(dateFormat.format(cal.getTime())); // get yesterday's Date without time part
    Date srcDate = new Date(st);
    Date srcDateWithoutTime =dateFormat.parse(dateFormat.format(srcDate));
    return yesterday.equals(srcDateWithoutTime ); // checks src date equals yesterday.
}