public Hashtable<Date, List<Date>> parseUserLogins(List<UserLogin> userLogins) {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
        List<Date> timeStamps = new ArrayList<Date>();

        for (UserLogin u : userLogins) {
            timeStamps.add(u.getTimeStamp());
        }

        for (Date ts : timeStamps) {

            cal.setTime(ts);
            cal.set(cal.HOUR_OF_DAY, 0);
            cal.set(cal.MINUTE, 0);
            cal.set(cal.SECOND, 0);
            cal.set(cal.MILLISECOND, 0);
            dateFormat.format(ts);

            if (!groupedUserLogins.containsKey(cal.getTime())) {

                groupedUserLogins.put(cal.getTime(), new ArrayList<Date>());
            }
            groupedUserLogins.get(cal.getTime()).add(ts);
        }

        keySet = groupedUserLogins.keySet();
        keyList.addAll(keySet);
        return groupedUserLogins;
    }