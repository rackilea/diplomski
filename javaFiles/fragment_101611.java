List<Polygon> plist;

// Populate the list with the polygons...

for (int i=0; i<plist.size(); i++) {
  Polygon p1 = plist.get(i);
  boolean distinct = false;
  while (!distinct) {
    distinct = true;
    for (int j=plist.size()-1 ; j>i; j--) {
      Polygon p2 = plist.get(j);
      if (p1.sharesEdge(p2)) {
        // Merge the two polygons
        p1.merge(p2);
        // One less shape
        plist.remove(j);
        distinct = false;
      } // if (p1.sharesEdge(p2))
    } // for (int j=plist.size()-1 ; j>i; j--) 
  } // while (!distinct)
} // for (int i=0; i<plist.size(); i++)