final LinkedHashMap<String, Double> testMap = new LinkedHashMap<String, Double>();
testMap.put("New", Double.valueOf(30.0));
testMap.put("Previous", Double.valueOf(70.0));

// The map contains two entries.
Set<Map.Entry<String, Double>> entries = testMap.entrySet();
Iterator<Map.Entry<String, Double>> it = entries.iterator();
Map.Entry<String, Double> firstEntry = it.next();
Map.Entry<String, Double> secondEntry = it.next();

Random r = new Random();
double percent = r.nextDouble() * 100;

// percent is a number between 0.0 and 100.0
if (percent < secondEntry.getValue().doubleValue()) // between 0.0 and 70.0 exclusive
{
    commands.get(commandWithMaxNegativeOffset).setDataCriteria(secondEntry.getKey());
}
else // between 70.0 inclusive to 100.0 (100.0 - 70.0 = 30.0)
{
    commands.get(commandWithMaxNegativeOffset).setDataCriteria(firstEntry.getKey());
}