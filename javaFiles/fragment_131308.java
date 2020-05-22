Properties p = new Properties();
p.setProperty("sample.user", "sampleUser");
p.setProperty("sample.age", "sampleAge");
p.setProperty("sample.location", "sampleLocation");

Pattern patt = Pattern.compile("sample.*");

final List<String> matchingValues = new ArrayList<>();

for (Entry<Object,Object> each : p.entrySet()) {
    final Matcher m = patt.matcher((String) each.getKey());
    if (m.find()) {
        matchingValues.add((String) each.getValue() );
    }
}

System.out.println(matchingValues);