enum AirplaneBrand{    
    AIRBUS(Arrays.asList("A380","A330")),
    BOEING(Arrays.asList("787","737"));       

    private List<String> values;    
    AirplaneBrand(List<String> values){ this.values = values; }    
    public List<String> myFunction(){  return values; }        
  }

    public static void main(String[] args){
        final Map<String, AirplaneBrand> MY_MAP =  
            Stream.of(AirplaneBrand.values())
                  .flatMap(en -> en.myFunction().stream().map(elt -> new AbstractMap.SimpleEntry<String,AirplaneBrand>(elt, en)))
                  .collect(toMap(Entry::getKey, Entry::getValue));

       System.out.println(MY_MAP);                 // {A330=AIRBUS, A380=AIRBUS, 787=BOEING, 737=BOEING}
        System.out.println(MY_MAP.get("737"));     // BOEING
        System.out.println(MY_MAP.get("A380"));    // AIRBUS
    }
}