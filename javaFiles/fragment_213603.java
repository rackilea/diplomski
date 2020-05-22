public int compareTo(Object other) {

 if (!(other instanceof Octagon)) {
   throw new IllegalArgumentException("Comparision with other types is not supported");
 }

 Integer thisSide = side;    // autoboxing, legal conversion since Java 1.5
 Integer otherSide = ((Octagon) other).side;     

 // Easy trick: Integer is already comparable ;)
 return thisSide.compareTo(otherSide);
}