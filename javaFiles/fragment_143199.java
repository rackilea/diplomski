import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

Multimap<String,String> mm=ArrayListMultimap.create(); //

mm.put("AAA", "123");
mm.put("AAA", "444");
mm.put("AAA", "555");
mm.put("BBB", "777");

// to use keySet
mm.keySet();

// getting values
Collection<String> values=mm.get("AAA");

for (String a_value: values) System.out.println("VALUE:"+a_value);