abstract class A { 
   public final String getTitle () { return getTitleInternal(); }
   abstract String getTitleInternal();

class B extends A {
   @Override
   String getTitleInternal { maybe return some static value of B }