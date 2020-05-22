class TestScala extends java.lang.Object with ScalaObject {
  <paramaccessor> private[this] val myNumber: Int = _;
  def this(myNumber: Int): $iw.$iw.TestScala = {
    TestScala.super.this();
    ()
  };
  private[this] val myNum: Int = TestScala.this.myNumber;
  <stable> <accessor> def myNum: Int = TestScala.this.myNum
}