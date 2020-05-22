String[] init=new String[] {"WALK", "I am walking", "SKIP", "I am skipping", ...}
Map lookup=new HashMap();
for(int i=0;i+=2;i<init.length)
{
    lookup.put(init[i],init[i+1])
}