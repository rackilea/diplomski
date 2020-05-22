@Test
    public void testAcceptFromOffice2() throws Exception {
        //given
        final Message message = new Message();
        doAnswer(new MakePersistentCallback()).when(messageDAO).makePersistent(message);

        //when
        messageService.acceptFromOffice(message);

        //then
        verify(messageDAO, times(2)).makePersistent(message);
    }


    private static class MakePersistentCallback implements Answer {

        private int[] expectedStatuses = {0, 1};
        private int invocationNo;

        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            final Message actual = (Message)invocation.getArguments()[0];
            assertThat(actual.getStatus()).isEqualTo(expectedStatuses[invocationNo++]);
            return null;
        }
    }