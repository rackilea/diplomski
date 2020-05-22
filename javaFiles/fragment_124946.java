class StatusMatcher(expectedValue: String) extends BeMatcher[Item] {
  def apply(left: Item) =
    MatchResult(
      left.status == expectedValue,
      left.toString + " did not have status " + expectedValue,
      left.toString + " had status " + expectedValue,
    )
}

val active = new StatusMatcher("ACTIVE")
val inactive = new statusMatcher("INACTIVE")

atLeast(1, reasons.items) must be (active)
atLeast(1, reasons.items) must be (inactive)