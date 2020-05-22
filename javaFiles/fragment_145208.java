public String getWeatherCondition(int temp, String weather, Context c) {

    Random r = new java.util.Random();

    if (temp >= -50 && temp < -15) {
        if (weather.contains("clear") && weather.contains("day")) {
            String[] conditions = c.getResources().getStringArray(R.array.minus15to0ClearDay);
            return conditions[r.nextInt(conditions.length)]);
        }
    }
    return "none";
}