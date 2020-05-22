onView(withText("Yes")).inRoot(isDialog()).withFailureHandler(new FailureHandler() {
            @Override
            public void handle(Throwable error, Matcher<View> viewMatcher){

            }
        }).check(matches(isDisplayed())).perform(customClick());

//if dialog is visible, perform click, otherwise do nothing.