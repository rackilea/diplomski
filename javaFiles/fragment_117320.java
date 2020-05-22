@Test
public void testingForFalse() {
    serviceImpl = new ServiceImpl() {
        @Override
        public boolean shouldRegister() {
            return false;
        }
    }

    // rest of the test
}