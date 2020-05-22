@Bean
@Primary
public MyDependency getMyDependency(){
    System.out.println("getMyDependency");
    return Mockito.mock(MyDependency.class);
}