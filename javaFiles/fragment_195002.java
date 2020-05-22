public List<Week> findAllBetween(int idFrom, int idTo) {
    Week from = get(idFrom);
    Week to = get(idTo);
    //select w Week w
    //where w.yearAndWeek between (from.yearAndWeek,to.yearAndWeek)
    //order by w.yearAndWeek
}