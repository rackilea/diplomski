class Player(val email: String) {
  override def equals(player: Any): Boolean = {
    player match {
      case p: Player => email.equals(p.email)
      case _ => false
    }
  }
}