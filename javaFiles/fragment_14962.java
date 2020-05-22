Map<String, Integer> values = new HashMap<>();
for (JDO total : table){
   String name = total.getCostName();
   Integer val = values.get(name);
   if (val == null) val = 0;
   val += total.getCost();
   values.put(name, val);
}
int total = values.get("food");