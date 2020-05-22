public class FooService {

    private List<FindFooStrategy> strategies = new ArrayList<>();

    public  FooService(){
      strategies.add(new FindFooByAAndBAndCStrategy());
      strategies.add(new FindFooByBAndCStrategy());
      strategies.add(new FindFooByAAndCStrategy());
      strategies.add(new FindFooByCStrategy());
    }

    public Foo getFoo(String a, String b, String c){

       for (FindFooStrategy strategy : strategies){
            if (strategy.isApplicable(a, b, c)) {
               return strategy.getFoo(a, b, c);
            }
       }
     }
}