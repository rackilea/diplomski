e2.getDates().clear();
for (final EventDate date : dates) {
    // this is necessary unfortunately
    date.setEvent(e2);
    e2.getDates().add(date);
}