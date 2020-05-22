NavigableMap<Double, List<Double>> characteristics = 
        new TreeMap<Double, List<Double>>();
characteristics.put(1.01, Arrays.asList(-7.0, 11.0, 9.0, 28.0));
...
Double key = characteristics.floorKey(cha);
// Null check omitted for brevity
List<Double> matchingCharacteristics = characteristics.get(key);