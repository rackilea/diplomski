@Inject @Dependent Instance<Stateful> stateful;

    @PostConstruct
     public void createStateless(){
         //instantiate sfList;
         sfList.add(stateful.get()); //execute as many times as you need
     }