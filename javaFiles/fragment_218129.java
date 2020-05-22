public double findMode(int[] inArray) {
        List<Integer> il = IntStream.of(inArray).boxed().collect(Collectors.toList());
        int maxFreq = 0;
        double value = 0;
        for (Integer i : ia){
            if (Collections.frequency(il, i) > maxFreq && i != value){
                maxFreq = Collections.frequency(il, i);
                value = i;
            } else if (Collections.frequency(il, i) == maxFreq && i != value) {
                value = Double.NaN; 
            }
        }
        return value;
}