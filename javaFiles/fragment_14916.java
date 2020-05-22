Foo instanceFooOne = fooService.performActions(data); 
Foo instanceFooTwo = fooService.performActions(data); 

class Foo{
private Object data;
    public Foo(Object data) {
        this.data = data;
    }
public Object getData(){
  return data;
}
}