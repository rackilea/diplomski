Entry<String, Double> min = null;
for (Entry<String, Double> entry : map.entrySet()) {
    if (min == null || min.getValue() > entry.getValue()) {
        min = entry;
    }
}

System.out.println(min.getKey()); // 0.1