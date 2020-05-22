@JsonView(View.Private.class)
    @GetMapping
    public MyEntity get(){
       ...
       return myEntity;
    } 

    @JsonView(View.Public.class)
    @GetMapping("url")   
    public List<MyEntity> getAll(){
       ...
      return entities;
    }