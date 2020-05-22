fun ViewInteraction.isDisplayed(): Boolean {
        try {
            check(matches(ViewMatchers.isDisplayed()))
            return true
        } catch (e: NoMatchingViewException) {
            return false
        }
    }

    if(onView(withText("my button")).isDisplayed()) {
        //view is displayed logic
    } else {
        //view not displayed logic
    }