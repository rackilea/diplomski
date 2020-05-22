private static final Set<Guitar> GUITARS = 
   Collections.unmodifiableSet(new HashSet(Arrays.asList(
      ...

 public Set<Guitar> getGuitars() {
     return GUITARS;
 }