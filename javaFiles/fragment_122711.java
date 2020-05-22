Map<String, String> mapProperties = new HashMap<String, String>();
Properties systemProperties = System.getProperties();
for(Entry<Object, Object> x : systemProperties.entrySet()) {
    mapProperties.put((String)x.getKey(), (String)x.getValue());
}

for(Entry<String, String> x : mapProperties.entrySet()) {
    System.out.println(x.getKey() + " " + x.getValue());
}