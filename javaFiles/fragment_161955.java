public static void printTree(Knoten blatt) {      
  Aufgabe1.Gewichte = Aufgabe1.Gewichte + blatt.Gewicht;
  System.out.println(blatt.Gewicht);

  for(int i = 0; i < blatt.children.size(); i++) {
    Knoten kind = blatt.children.get(i);  // Don't overwrite blatt here
    printTree(kind);
  } 
}