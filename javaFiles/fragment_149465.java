public static void main(String[] args) throws Exception {
      A a = new A();
      a.setValue1(1.0);
      a.setValue2(5);

      B b = new B();

      Method[] methods = b.getClass().getMethods();
      for ( Method m : methods ) {
         if ( m.getName().equals("setValue2") ) {
            m.invoke(b, transform(a.getValue2(), m.getParameterTypes()[0]));
         }
      }
      System.out.println(b.getValue2());
   }

   private static Number transform(Number n, Class<?> toClass) {
      if ( toClass == Long.class ) {
         return n.longValue();
      } else if ( toClass == Double.class ) {
         return n.doubleValue();
      }
      //instead of this you should handle the other cases exhaustively
      return null;
   }