Iterator<Map.Entry<String, Integer>> iterator = vec.entrySet().iterator();
Map.Entry<String, Integer>> entry = iterator.next();
for (int i = 0; i < n; i++)
{
    entry = iterator.next();
}
String randomVehicle = entry.getKey();
Integer randomAmount = entry.getValue();