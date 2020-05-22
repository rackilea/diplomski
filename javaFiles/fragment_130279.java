public static double notNull(Double doubleObj, double defaultValue) {
   return doubleObj == null? defaultValue: doubleObj.doubleValue();
}

// use this way (getPropertyDouble() returns a java.lang.Double)

notNull(myObj.getPropertyDouble(), -1.0);