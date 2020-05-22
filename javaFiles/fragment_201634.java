// ARRANGE:
MyActivity vMyActivity = getActivity();
MyApp expectedAppContext = vMyActivity.getApplicationContext();

// ACT: 
// No need to "act" much since MyActivityLogic object is created in the 
// constructor of the activity
MyActivityLogic vLogic = vMyActivity.getMyActivityLogic();

// ASSERT: Make sure the same ApplicationContext singleton is inside
// the MyActivityLogic object
MyApp actualAppContext = vLogic.getMyApp();
assertSame(expectedAppContext, actualAppContext);