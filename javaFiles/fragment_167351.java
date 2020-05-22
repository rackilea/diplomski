public void test_click(){
    // Click on the `some_button`
    onView(withId(R.id.some_other)).perform(click());

    // Or click on view with the text 'OK`
    onView(withText("OK")).perform(click());

    // Check that a view with R.id.some_other_button is displayed
    onView(withId(R.id.some_other_button)).check(matches(isDisplayed()));
}