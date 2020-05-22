boolean contains = false;
for (Entry<Pattern, Integer> entry : map.entrySet())
{
    Pattern patt = entry.getKey();
    if ( p.equals(patt) ){
        contains = true;
    }
}
if ( contains ){
  int time = map.get(p);
  time++;
  map.put(p, time);
} else
  map.put(p, 0);