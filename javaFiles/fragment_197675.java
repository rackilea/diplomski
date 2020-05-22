try {
   Integer i1 = (Integer) n.e1.accept(this);
   Integer i2 = (Integer) n.e2.accept(this);
} catch (ClassCastException e) {
   // code reached when one of them is not Integer
}