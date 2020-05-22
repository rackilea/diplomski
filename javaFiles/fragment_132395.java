@Test
    public void testCheckForFullLoading() throws Exception {

        when(sortingExecutionCore.countOfFreeThreads()).thenReturn(1);
        when(taskService.waitingTaskCount()).thenReturn(1);

        sortingService.checkForFullLoading();  //Stubbed method on mocked class.
        verify(sortingService, times(1)).startForNewSort();

    }