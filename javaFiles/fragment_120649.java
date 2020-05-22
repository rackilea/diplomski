scala> :paste
// Entering paste mode (ctrl-D to finish)

trait Foo
trait InnerFoo
trait Bar extends Foo
trait Baz extends Foo
object Bar {
    class InnerBar extends InnerFoo
    def newInstance: InnerBar = new InnerBar
    def build: Bar = new Bar {}
}
object Baz {
    class InnerBaz extends InnerFoo
    def newInstance: InnerBaz = new InnerBaz
    def build: Baz = new Baz {}
}

// Exiting paste mode, now interpreting.

defined trait Foo
defined trait InnerFoo
defined trait Bar
defined trait Baz
defined object Bar
defined object Baz