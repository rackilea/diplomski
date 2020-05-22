onView(R.id.parentLayout)
  .check(matches(allOf(
    isDisplayed(), 
    withChild(withText("A")),
    withChild(withText("B"))
)));