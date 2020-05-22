trait Validator[T] {
  def validate(value: T): Boolean
}

case class ValidatedValue[T, V <: Validator[T]](value: T)(implicit validator: V) {
  if (!validator.validate(value))
    throw new IllegalArgumentException(s"value `$value` does not pass validator")
}

object ValidatedValue {
  implicit def apply[T, VOld <: Validator[T], VNew <: Validator[T]](value: ValidatedValue[T, VOld])(implicit validator: VNew): ValidatedValue[T, VNew] = ValidatedValue(value.value)
}