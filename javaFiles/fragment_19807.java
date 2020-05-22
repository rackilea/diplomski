abstract class MaxLength(val maxLen: Int) extends Validator[String] {
  override def validate(value: String): Boolean = value.length < maxLen
}

object MaxLength {

  implicit object MaxLength50 extends MaxLength(50)

  type MaxLength50 = MaxLength50.type
  type String50 = ValidatedValue[String, MaxLength50]

  implicit object MaxLength100 extends MaxLength(100)

  type MaxLength100 = MaxLength100.type
  type String100 = ValidatedValue[String, MaxLength100]
}