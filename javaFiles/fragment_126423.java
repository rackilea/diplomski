Set a = getSetA();
Set b = getSetB();

// create union
Set union = new Set(a);
union.addAll(b);

// remove intersection
for (Object inA : a)
  if(b.contains(inA))
    union.remove(inA);