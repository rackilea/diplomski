Map<String, String[]> map = new HashMap<>();
String input = "abc 1/2/3 3/4/5 4/5/6 6/7/7 efg 1 2 3 4";
String[] exps = input.split("\\s+(?=[A-Za-z]+)");
for (String exp : exps) {
    String[] parts = exp.split("\\s+");
    map.put(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
}

// iterate each name, and then print out each string in a given array
for (Map.Entry<String, String[]> entry : map.entrySet()) {
    for (String val : entry.getValue()) {
        System.out.println(entry.getKey() + ": " + val);
    }
}

abc: 1/2/3
abc: 3/4/5
abc: 4/5/6
abc: 6/7/7
efg: 1
efg: 2
efg: 3
efg: 4