HashMap<String, String> hmap = new HashMap<String, String>();
for(int i=0;i<a1.size();i++){
  hmap.put(a1.get(i),a11.get(i));
}

for(Map.Entry m:hmap.entrySet())
{  
   System.out.println("Key :"+m.getKey()+"Value:"+m.getValue());  

}