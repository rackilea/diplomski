class Conv {
  def b(i: Int) = i.toByte
  def B(i: Int) = i.asInstanceOf[Byte]
  def s(i: Int) = i.toShort
  def S(i: Int) = i.asInstanceOf[Short]
  def f(i: Int) = i.toFloat 
  def F(i: Int) = i.asInstanceOf[Float]  
  def d(i: Int) = i.toDouble
  def D(i: Int) = i.asInstanceOf[Double]
}