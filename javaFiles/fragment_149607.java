@Column(name = "timestamp", index = true)
private Date timestamp; 

//and the date will be serialized to SQLite. You can parse strings into a Date object using SimpleDateFormat:

public void setDateFromString(String date) throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
    sf.setLenient(true);
    this.timestamp = sf.parse(date);
}