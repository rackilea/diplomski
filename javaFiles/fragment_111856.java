...
} else if(comparison > 0) { // new City should appear before this one   
   stringListIterator.previous();
   stringListIterator.add(newCity);
   return true;
} else { ... }