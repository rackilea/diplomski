public class FindFooByAAndBAndCStrategy implements FindFooStrategy{
  public boolean isApplicable(String a, String b, String c){
      return StringUtils.isNotEmpty(a) && StringUtils.isNotEmpty(b) &&
             StringUtils.isNotEmpty(c);
  }
  public Foo getFoo(String a, String b, String c){
      return repository.findByAAndBAndC(a,b,c);
  } 
}