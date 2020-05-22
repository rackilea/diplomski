List<Person> filtered = new ArrayList<>();
 for(Person p : people) {
     if(p.age() < 19) {
         filtered.add(p);
     }
 }
 return filtered;