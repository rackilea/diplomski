HashMap<String, String> x;

Random       random    = new Random();
List<String> keys      = new ArrayList<String>(x.keySet());
String       randomKey = keys.get( random.nextInt(keys.size()) );
String       value     = x.get(randomKey);