public static void main(String[] args) {
        Date date = parseJSONDateTime("2015-05-07T17:00:00Z");
        System.out.println(date);
    }

    public static Date parseJSONDateTime(String jsonDateString) {
        if (jsonDateString == null) return null;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        if (jsonDateString.contains("T")) jsonDateString = jsonDateString.replace('T', ' ');
        if (jsonDateString.contains("Z")) jsonDateString = jsonDateString.replace("Z", "+0000");
        else
            jsonDateString = jsonDateString.substring(0, jsonDateString.lastIndexOf(':')) + jsonDateString.substring(jsonDateString.lastIndexOf(':')+1);
        try {
            return fmt.parse(jsonDateString);
        }
        catch (ParseException e) {
            e.printStackTrace(); return null;
        }
    }