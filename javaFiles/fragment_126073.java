public int equals(Object o) {
         if (o instanceof of MyClass) {
             MyClass m = (MyClass)o;
             return m.a == a && m.b == b && Arrays.equals(m.array, array);
         }
         else 
             return false;
    }