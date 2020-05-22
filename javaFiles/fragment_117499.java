Calendar cal = Calendar.getInstance();
cal.set(Calendar.YEAR, 2012);
cal.set(Calendar.MONTH, 3); // NOTE: 0 is January, 1 is February, etc.
cal.set(Calendar.DAY_OF_MONTH, 2);
cal.add(Calendar.DAY_OF_MONTH, 10); // add 10 days
Date date = cal.getTime();