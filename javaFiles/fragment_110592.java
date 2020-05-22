// takeInteger(int) takeDouble(double) takeObject(Object) takeIntegerObject(Integer)

takeInteger(5);  // an identity conversion
takeDouble(5);   // a widening primitive conversion
takeObject(new Integer(5)); // a widening reference conversion
takeIntegerObject(5);   // a boxing conversion
takeObject(5);   // a boxing conversion followed by widening reference conversion
takeInteger(new Integer(5)); // an unboxing conversion
takeDouble(new Integer(5)); // an unboxing conversion followed by a widening primitive conversion.