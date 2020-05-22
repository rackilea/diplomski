getDataByDateInterval(Date from, Date to) {
    //...
}

getDataByWeek(Date to) {
    // Calculate 'from' date (minus 7 days)
    return getDataByDateInterval(from, to);
}