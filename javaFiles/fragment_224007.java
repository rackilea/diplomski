interface TypeIdentifiable {}

interface TypeCloneable extends Cloneable {
  public Object clone() throws CloneNotSupportedException;
}

class Foo implements TypeCloneable, TypeIdentifiable {

   @Override
   public Object clone() throws CloneNotSupportedException {
      // ...
      return null;
   }
}

interface TypeCloneableAndIndetifiable extends TypeCloneable, TypeIdentifiable  {

}
abstract class AbstractClass<T extends TypeCloneableAndIndetifiable> {

   public void foo(T element) throws Exception {
      TypeCloneable cloned = (TypeCloneable) element.clone();
      System.out.println(cloned);
   }
}