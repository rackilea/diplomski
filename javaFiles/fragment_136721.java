class MyObject {
    String myProp1;
    String myProp2;
    String myProb3;
    BigDecimal myDouble;

    public MyObject(String myProp1, String myProp2, String myProb3, BigDecimal myDouble) {
        super();
        this.myProp1 = myProp1;
        this.myProp2 = myProp2;
        this.myProb3 = myProb3;
        this.myDouble = myDouble;
    }
    public void addDouble(BigDecimal addValue) {
        myDouble = myDouble.add(addValue);
    }
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((myProb3 == null) ? 0 : myProb3.hashCode());
        result = PRIME * result + ((myProp1 == null) ? 0 : myProp1.hashCode());
        result = PRIME * result + ((myProp2 == null) ? 0 : myProp2.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MyObject other = (MyObject) obj;
        if (myProb3 == null) {
            if (other.myProb3 != null)
                return false;
        } else if (!myProb3.equals(other.myProb3))
            return false;
        if (myProp1 == null) {
            if (other.myProp1 != null)
                return false;
        } else if (!myProp1.equals(other.myProp1))
            return false;
        if (myProp2 == null) {
            if (other.myProp2 != null)
                return false;
        } else if (!myProp2.equals(other.myProp2))
            return false;
          return true;
        }
      }