Returns:
a string representation of the object.


    public String  toString() {
         return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }