public class MyObject {
private String name;

//getter and setters


public int hashCode() {
   int hashCode = //Do some object specifc stuff to gen hashCode
   return int;
}

public boolean equals(Object obj) {
   if(this==obj) return true;
   if(obj instanceOf MyObject) {
       if(this.name.equals((MyObject)obj.getName())) {
           return true;
       }
   return false;
}
}
}