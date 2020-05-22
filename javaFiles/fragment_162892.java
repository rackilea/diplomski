HashMap<Foo2, HashMap<Foo3, Double>> map2 = my_map.get(foo1Key);
if(map2!=null) {
  HashMap<Foo3, Double> map3 = map2.get(foo2Key);
  if (map3!=null) {
    Double value = map3.get(foo3Key);
    if (value!=null) {
      return (double)value;
    } else {
      // add value to map3, or whatever
    }
  }
}