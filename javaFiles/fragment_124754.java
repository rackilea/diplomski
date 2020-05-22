onView(allOf(
         withId(R.id.childHorizontalRecyclerView),
         withParent(
           withRecyclerView(R.id.parentVerticalRecyclerView).atPosition(2)
         )
       )
).perform(RecyclerViewActions.actionOnItemAtPosition(3, scrollTo()))
.check(matches(hasDescendant(withText("USA"))));