@Test
        public void testSomethingOrAnother() {
            B target = null;
            try {
                target = EasyMock.createMockBuilder(B.class).addMockedMethod(B.class.getDeclaredMethod("getData")).createMock();
                EasyMock.expect(target.getData()).andThrow(new SomeException());
                EasyMock.replay(target);
            } catch (NoSuchMethodException e) {
                fail(e.getMessage());
            } catch (SomeException e) {
                fail(e.getMessage());
            }

            try {
                target.doWork();
                fail("doWork should have thrown an exception");
            } catch (OtherException e) {
                //pass
            }
        }