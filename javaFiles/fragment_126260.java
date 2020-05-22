testObject.showFollowersList(followers);
// All that method does is add listener. So check that listener got added
assertEquals(1, testObject.getList().getListenerCount());

// Now check that inner handlers behave correctly
testObject.getList().fireEvent();
// This should have created a new RowData in the list
assertNotNull(testObject.getList().getLayoutData());