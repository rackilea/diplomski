Map<Integer, Pair<Double, SelectedRoad>> hashmap3 =
  new LinkedHashMap<Integer, Pair<Double, SelectedRoad>>();

// [...] add 216 elements to hasmap3 here somehow

ArrayList<Pair<Double,SelectedRoad>> firstPairs = 
  Collections.list(Collections.enumeration(hashmap3.values())).subList(0, 100)

// you can then view your Pairs' SelectedRow values with them with:
//  (assuming that:
//    - your Pair class comes from Apache Commons Lang 3.0
//    - your SelectedRoad class implements a decent toString() )
for (final Pair<Double, SelectedRoad> p : firstPairs) {
    System.out.println("double: " + p.left);
    System.out.println("road  : " + p.right);
}