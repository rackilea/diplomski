@Bean
@Scope(value="request")
@ScopeProxy
public RequestBean createBean(){
   return new RequsetBean();
}