private static class BeerComparator implements Comparator<Beer> {
     @Override
     public int compare(Beer b1, Beer b2) {
         //return a value > 1 if b1 is greater than b2, < 1 if b2 greater than b1,
         //and exactly 0 if the two are equal
     }
}

beers = new TreeMap<Beer, Integer>(new BeerComparator());