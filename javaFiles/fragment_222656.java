try {
        onView(withText("my button")).check(matches(isDisplayed()));
        //view is displayed logic
    } catch (NoMatchingViewException e) {
        //view not displayed logic
    }