trait IHolder[LType] {
  type L = LType
  def l: LType
}

object Holder extends IHolder[String] {
  override val l: L = "foo" //this typechecks
}