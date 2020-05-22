Map<String, Double> source = repository.getSourceData();
Map<String, Double> target = repository.getTargetData();

Map <String, Double> matched = new HashMap<>();
Map <String, List<Double>> mismatched = new HashMap<>();
Map <String, String> unmatched = new HashMap<>();
for (String keySource : source.keySet()) {
    Double dblSource = source.get(keySource);
    if (target.containsKey(keySource)) { // keys match
        Double dblTarget = target.get(keySource);
        if (dblSource.equals(dblTarget)) { // values match
            matched.put(keySource, dblSource);
        } else { // values don't match
            mismatched.put(keySource, new ArrayList<Double>(Arrays.toList(dblSource, dblTarget)));
        }
    } else { // key not in target
        unmatched.put(keySource, "Source");
    }
}
for (String  keyTarget : target.keySet()) { // we only need to look for unmatched
    Double dblTarget = target.get(keyTarget);
    if (!source.containsKey(keyTarget)) {
        unmatched.put(keyTarget, "Target");
    }
}

// print out matched
System.out.println("Matched");
System.out.println("=======");
System.out.println("Key\tValue");
System.out.println("=======");
for (String key : matched.keySet()) {
    System.out.println(key + "\t" + matched.get(key).toString());
}

// print out mismatched
System.out.println();
System.out.println("Mismatched");
System.out.println("=======");
System.out.println("Key\tSource\tTarget");
System.out.println("=======");
for (String key : mismatched.keySet()) {
    List<Double> values = mismatched.get(key);
    System.out.println(key + "\t" + values.get(0) + "\t" + values.get(1));
}

// print out unmatched
System.out.println();
System.out.println("Unmatched");
System.out.println("=======");
System.out.println("Key\tWhich\tValue");
System.out.println("=======");
for (String key : unmatched.keySet()) {
    String which = unmatched.get(key);
    Double value = null;
    if ("Source".equals(which)) {
        value = source.get(key);
    } else {
        value = target.get(key);
    }
    System.out.println(key + "\t" + which + "\t" + value);
}