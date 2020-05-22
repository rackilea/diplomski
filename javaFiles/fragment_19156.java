class DataClass {
      String source;
      String destination;

      // ...

    @Override
    public boolean equals(Object obj) {
        // ...
        ObjectClass other = (ObjectClass) obj;
        if(i.equals(other.getJ())
            && j.equals(other.getI())) {
            return true;
        } else return false;
    }