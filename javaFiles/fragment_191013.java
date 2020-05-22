//Start SongLoader
ExecutorService songLoaderService = SongLoader.getExecutorService();
songLoaderService.submit(loader);

//SongLoader uses CompletionService when calls LoadFolderWorkers so shutdown wont return until all folder
//submissions completed to the MainAnalyserService
songLoaderService.shutdown();
songLoaderService.awaitTermination(10, TimeUnit.DAYS);
MainWindow.userInfoLogger.severe(">Song Loader Finished");

//Were now allowed to consider closing the latch because we know all songs have now been loaded
//so no false chance of zeroes
analyserService.setSongLoaderCompleted();

//Just waits for all the async tasks on the list to complete/fail
analyserService.awaitCompletion();
MainWindow.userInfoLogger.severe(">MainAnalyser Completed");

//This should be immediate as there should be no tasks still remaining
analyserService.getExecutorService().shutdown();
analyserService.getExecutorService().awaitTermination(10, TimeUnit.DAYS);