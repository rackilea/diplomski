// create map (done only once, of course)
TreeMap<LocalDate, Record> records = new TreeMap<>();
for (Record r : recordList) {
    records.put(r.getTimeWindow().getBeginDate(), r);
}

// find record for a given date
public String getValueForDate(LocalDate date) {
    Record floor = records.floorEntry(date).getValue();
    if (floor.dateMatchesWindow(date)) {
        return r;
    }
    return null;
}