trait Extended extends Base {
  ...
}

object Extended {
  def apply(arg1: Int) = new Base(arg1) with Extended
  def apply(arg2: String) = new Base(arg2) with Extended
  def apply(arg3: Double) = new Base(arg3) with Extended
}