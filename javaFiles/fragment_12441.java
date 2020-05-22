class Building<B extends Building<B, X>, X extends Thing<B, X>> {
  Shop<B,X> s = new Shop<>();
  X makesError = s.getLocation(this);
}
class Shop<S extends Building<S, X>, X extends Thing<S, X>> {
   public X get_location(S shop) {...}
}