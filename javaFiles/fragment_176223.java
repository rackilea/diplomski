scala> :pa
// Entering paste mode (ctrl-D to finish)

class Vector2(x0: Float, y0: Float) extends gdx.math.Vector2(x0, y0) {
  def copy(x: Float = this.x, y: Float = this.y): Vector2 = {
    new Vector2(x, y)
  }
}

object Vector2 {
  def apply(x: Float = 0, y: Float = 0): Vector2 = {
    new Vector2(x, y)
  }
}

// Exiting paste mode, now interpreting.

defined class Vector2
defined object Vector2

scala> Vector2(1, 2).x
res1: Float = 1.0