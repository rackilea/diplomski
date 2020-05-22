import static java.util.stream.Collectors.*;
...
Map<String, List<Entry<Parameter, String>>> mapList = new HashMap<>();

myMap.forEach((k, v) -> { 
   List<Entry<Parameter, String>> filtered = v.entrySet().stream()
   .filter(e -> e.getValue().equals("GOOD"))
   .collect(toList());

   if(!filtered.isEmpty()) mapList.put(k, filtered);
});