Object testObject = new Object() {
    private void testMe() { 
        System.out.println("testme");
    }
};
Method m = testObject.getClass().getDeclaredMethod("testMe");
m.setAccessible(true);
m.invoke(testObject); // prints out "testme"