Man maxAge = new Man(0);
boolean isAmaxFoud = false;

for(Man man : list) {
  if(man.age > maxAge.age) {
    maxAge = man;
    isAmaxFound = true;
  }
}

if(!isAmaxFound) // <<--- all age are equal
      print "Equals "+list.get(0)
else print maxAge