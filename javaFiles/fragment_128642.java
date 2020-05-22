public boolean remove(String earthquakeLo, String earthquakeDt) {
   boolean flag= false;
   Iterator<EarthquakeNode> iterator = records.iterator();
   while(iterator.hasNext()) {
      EarthquakeNode earthquake = iterator.next();
      if(earthquake.getLocation().equalsIgnoreCase(earthquakeLo)) {
           if(earthquake.getDate().equals(earthquakeDt)) {
              iterator.remove();
              flag=true;
           }
      }
   }
   return flag;
 }