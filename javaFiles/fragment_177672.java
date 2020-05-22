public static Number addition(Number summand1, Number summand2) {
     if (!summand1.getClass().equals(summand2.getClass()))
          throw new IllegalArgumentException("Two different classes are used in the parameters: " + summand1.getClass().getName() + ", " + summand2.getClass().getName());
     if(summand1 instanceof Double && summand2 instanceof Double)
          return new Double(summand1.doubleValue() + summand2.doubleValue());
     else if(summand1 instanceof Float && summand2 instanceof Float)
          return new Float(summand1.floatValue() + summand2.floatValue());