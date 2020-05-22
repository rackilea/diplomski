+ public interface MyClass // declares getters
+- public interface Id {...} // MyClass.Id declares getters for id's
|
+--+ public interface MyClassWritable extends MyClass // declares setters
   |
   +-- public class MyClassImpl implements MyClassWritable