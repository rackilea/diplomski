public void testMethod ( )
{
    MyInterface mockObject = new MyInterface ( ) {
        public void myMethod ( )
        {
            // NOOP
        }

        public int myFunction ( )
        {
            return -1 ;
        }
    }

    // Proceed with the test case using mockObject
}