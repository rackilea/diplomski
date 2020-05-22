scala> :paste
// Entering paste mode (ctrl-D to finish)

class Test(private val value: Int)

object Test {
  def testMethod(t: Test) = t.value
}

// Exiting paste mode, now interpreting.

defined class Test
defined module Test

scala> Test.testMethod(new Test(5))
res1: Int = 5