int week = 1;
int year = 2016;
WeekFields weekFields = WeekFields.of(Locale.getDefault());
LocalDateTime ldt = LocalDateTime.now()
                            .withYear(year)
                            .with(weekFields.weekOfYear(), week)
                            .with(weekFields.dayOfWeek(), 1);
System.out.println(ldt);