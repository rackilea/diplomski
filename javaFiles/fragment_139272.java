Map<String, Float> monthMap = new HashMap<>();
for (Entry uploadResult : uploadResults) {
    String month = uploadResult.getMonth();
    Float powerOutput = uploadResult.getPowerOutput();

    if( monthMap.containsKey(month) ){
        powerOutput += monthMap.get(month);
    }
    monthMap.put( month, powerOutput);
}
System.out.println(monthMap);