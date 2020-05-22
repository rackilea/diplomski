private final static SharedAccessBlobPolicy createSharedAccessBlobPolicy(EnumSet<SharedAccessBlobPermissions> sap,
            int expireTimeInSeconds) {
        Calendar now = Calendar.getInstance();
        TimeZone timeZone = now.getTimeZone();
        System.out.println("Current TimeZone is : " + timeZone.getDisplayName());
        String x = timeZone.getDisplayName();
        String[] myName = x.split(" ");
        String s = "";
        ArrayList zoneArray = new ArrayList<>();
        char zone = 0;
        for (int i = 0; i < myName.length; i++) {
            s = myName[i];
            System.out.print(s.charAt(0));
            zone = s.charAt(0);
            zoneArray.add(zone);
        }
        String timeZoneCurrent = s;
        String timeZoneDynamic = zoneArray.toString().replace(",", "").replace(" ", "").replace("[", "").replace("]",
                "");
        System.out.println("Value of S==========" + timeZoneDynamic);
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(timeZoneDynamic));
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, expireTimeInSeconds);
        SharedAccessBlobPolicy policy = new SharedAccessBlobPolicy();
        policy.setPermissions(sap);
        policy.setSharedAccessExpiryTime(cal.getTime());
        return policy;
    }