error: method aMethod in class Box<T> cannot be applied to given types;
    B b2 = box.aMethod(c); // Compile time error
              ^
  required: B
  found: C
  reason: argument mismatch; C cannot be converted to B
  where T is a type-variable:
    T extends Object declared in class Box
1 error