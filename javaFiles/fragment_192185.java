trait BaseUserDao[T <: BaseUser] {
  def insertUser(user: T) : Boolean
}

class SpecificUserDao[SpecificUser]  extends BaseUserDao[SpecificUser] {
  override def insertUser(user: SpecificUser): Boolean = ???
}