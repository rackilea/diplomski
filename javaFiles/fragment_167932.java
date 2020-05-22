$ scalac -print Vector2d.scala
[[syntax trees at end of                   cleanup]] // Vector2d.scala
package <empty> {
  class Vector2D extends Object {
    <paramaccessor> private[this] val x: Float = _;
    <stable> <accessor> <paramaccessor> def x(): Float = Vector2D.this.x;
    <paramaccessor> private[this] val y: Float = _;
    <stable> <accessor> <paramaccessor> def y(): Float = Vector2D.this.y;
    def <init>(x: Float, y: Float): Vector2D = {
      Vector2D.this.x = x;
      Vector2D.this.y = y;
      Vector2D.super.<init>();
      ()
    }
  }
}