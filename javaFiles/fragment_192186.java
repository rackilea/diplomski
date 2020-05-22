trait BaseUserDao {
  type T <: BaseUser
  def insertUser(user: T) : Boolean
}

class SpecificUserDao  extends BaseUserDao {
  override type T = SpecificUser
  override def insertUser(user: SpecificUser): Boolean = ???
}