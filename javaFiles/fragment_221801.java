[[syntax trees at end of                     mixin]] // test20.scala
package <empty> {
  abstract trait X extends Object {
    <accessor> def X$_setter_$x_=(x$1: Int): Unit;
    <stable> <accessor> def x(): Int
  };
  class Y extends Object with X {
    <stable> <accessor> def x(): Int = Y.this.x;
    private[this] val x: Int = _;
    <accessor> def X$_setter_$x_=(x$1: Int): Unit = Y.this.x = x$1;
    def <init>(): Y = {
      Y.super.<init>();
      X$class./*X$class*/$init$(Y.this);
      ()
    }
  };
  abstract trait X$class extends  {
    def /*X$class*/$init$($this: X): Unit = {
      $this.X$_setter_$x_=(5);
      ()
    }
  }
}