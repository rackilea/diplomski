// a method inside B
public void applyA(A a) {
  // if B is currently related to A, break the relation
  if ( this.a != null ) {
    this.a.getBList().remove( this );
  }
  // apply the relation to both sides
  this.a = a;
  if ( a != null ) {
    a.getBList().add( this );
  }
}