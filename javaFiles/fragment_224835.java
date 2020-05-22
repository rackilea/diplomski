for(final Map.Entry<String,Integer> entry : freqMap.entrySet()) {
    final String key = entry.getKey();
    final Integer value = entry.getValue();
    final float percentage = /* calculate percentage here */ ;

    System.out.println(key + " = " + value + " => " + percentage);
}