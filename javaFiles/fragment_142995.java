Integer first = null;

for(Integer i : map.keySet()) {
    if(first == null) first = i; // save the first value
    builder.append(i - first);
}