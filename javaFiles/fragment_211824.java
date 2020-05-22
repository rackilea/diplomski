// Get the Class object for the class of which test is a field
Class<?> myClass = MyClass.class;

// We will need to set test as accessible so as to change it's value
// Get the Field object for test
Field testField = myClass.getDeclaredField("test");
// Save the current accessibility of test
boolean wasAccessible = testField.isAccessible();
// Mark test as accessible
testField.setAccessible(true);
// Set the value of test for this instance of MyClass
int newTestValue = 42;
testField.setInt(this, newTestValue);
// Restore the accesibility of test to it's original
testField.setAccessible(wasAccessible);