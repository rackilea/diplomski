@Override
   public int compareTo(MyData another)
   {
      Integer myVal = this.intVal;
      Integer otherVal = another.intVal;
      return myVal.compareTo(otherVal);
   }