int seconds=98765410;
int weeks = (int) (TimeUnit.SECONDS.toDays(seconds) / 7);
int days = (int) (TimeUnit.SECONDS.toDays(seconds) - 7 * weeks);
long hours = TimeUnit.SECONDS.toHours(seconds) - TimeUnit.DAYS.toHours(days) - TimeUnit.DAYS.toHours(7*weeks);
long minutes = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
System.out.println(weeks+"w "+days+"d "+hours+"h "+minutes+"m");