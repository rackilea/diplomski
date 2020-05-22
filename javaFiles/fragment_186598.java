Calendar start = Calendar.getInstance();
start.setTime(date1);
Calendar end = Calendar.getInstance();
end.setTime(date2);

Integer[] elapsed = new Integer[6];
Calendar clone = (Calendar) start.clone(); // Otherwise changes are been reflected.
elapsed[0] = elapsed(clone, end, Calendar.YEAR);
clone.add(Calendar.YEAR, elapsed[0]);
elapsed[1] = elapsed(clone, end, Calendar.MONTH);
clone.add(Calendar.MONTH, elapsed[1]);
elapsed[2] = elapsed(clone, end, Calendar.DATE);
clone.add(Calendar.DATE, elapsed[2]);
elapsed[3] = (int) (end.getTimeInMillis() - clone.getTimeInMillis()) / 3600000;
clone.add(Calendar.HOUR, elapsed[3]);
elapsed[4] = (int) (end.getTimeInMillis() - clone.getTimeInMillis()) / 60000;
clone.add(Calendar.MINUTE, elapsed[4]);
elapsed[5] = (int) (end.getTimeInMillis() - clone.getTimeInMillis()) / 1000;

System.out.format("%d years, %d months, %d days, %d hours, %d minutes, %d seconds", elapsed);