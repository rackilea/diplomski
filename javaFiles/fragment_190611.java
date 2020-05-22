for (ListIterator<Integer> listIterator = primes.listIterator(); listIterator.hasNext();) {
     int i = listIterator.next();
     if(no % i != 0){
         no2 = no2 + 1;
         if(primes.size() == no2){
              System.out.println(primes.get(primes.size() - 1));
              listIterator.add(no);
         }
     }
}