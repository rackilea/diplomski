public static void main (String[] args) throws java.lang.Exception
{
    Map<String, Long> times = new HashMap<String, Long>();
    times.put("y", 365L*24*60*60); // Or 366 days?
    times.put("m", 31L*24*60*60); // Or 30 days?
    times.put("w", 7L*24*60*60);
    times.put("d", 24L*60*60);
    times.put("h", 60L*60);


    String s = "1w3d4m";
    long sum = 0L;

    Matcher m = Pattern.compile("(\\d+)([A-Za-z]+)").matcher(s);
    while (m.find())
    {
        String type = m.group(2);
        String multiplier = m.group(1);
        sum += times.get(type) * Integer.parseInt(multiplier);
    }

    System.out.println(sum);
}