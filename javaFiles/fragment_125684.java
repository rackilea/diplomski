Set<Integer> indexes = new HashSet<Integer>();
for(int i=0; i<time.size(); i++){
   if (cpu.get(i) == myVal) {
      indexes.add(i);
   }
}