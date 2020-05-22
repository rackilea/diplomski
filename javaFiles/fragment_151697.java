class B{

@Autowired
private SomeClass someClass;

public B(int a,String b, SomeClass someClass)
{
    //method implementation
    this.someClass = someClass;
}