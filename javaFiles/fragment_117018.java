public class BaseClass<T extends FieldBaseClass> {
  protected T field;

  public T getField() {
    return field;
  } 
}

public class ChildClass extends BaseClass<FieldChildClass> {

}