Calendar timeStartPoint = Calendar.getInstance();

timeStartPoint.set(11, 0); // hour of day
timeStartPoint.set(12, 0); // minute
timeStartPoint.set(13, 0); // second
timeStartPoint.set(14, 0); // millisecond
timeStartPoint.set(5, monthStartPoint ? 1 : 5); // day of month
timeStartPoint.set(2, 0); // month (zero-based!)
timeStartPoint.set(1, 2004); // year