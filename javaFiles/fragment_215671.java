String sql = "select * from dbo.MarketHolidays ";
List<MarketHolidays> marketHolidaysList = jdbcTemplate.jdbcTemplate.queryForList(sql, MarketHolidays.class);

 Map<String, List<MonthDay>> map = Maps.newHashMap();

 marketHolidaysList.forEach(m -> {
  Date holidayDate = m.getHolidayDate();
  LocalDate date = holidayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  MonthDay monthDay = MonthDay.of(date.getMonth(), date.getDayOfMonth());

  map.computeIfAbsent(m.getMarketName(), s -> new ArrayList<>()).add(monthDay);
});