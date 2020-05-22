@PostConstruct
  public void init(){
   System.out.println(url );
    if(baseUrl.equals(""){
        throw new RuntimeException("missing");
     }
  }