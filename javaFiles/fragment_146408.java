HashMap <String,HashMap> holder = new HashMap<>();
HashMap <Integer,Integer> hm1 = new HashMap<>();
HashMap <Integer,String> hm2 = new HashMap<>();
hm1.put(0,10000000);
hm1.put(1,5000);
hm2.put(0,"xxxx-xxxx-xxxx");
hm2.put(1,"yyyy-yyyy-yyyy");

holder.put("Amt", hm1);
holder.put("Info", hm2);

Iterator<String> iterator = holder.keySet().iterator();

while(iterator.hasNext())
{String key = iterator.next();
 System.out.println("key: " + key + " value: " + holder.get(key));
}