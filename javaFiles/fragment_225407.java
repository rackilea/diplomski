Future<Set<Image>> future =
  Executors.newSingleThreadExecutor().submit(new Callable<Set<Image>>()
    {
      @Override
      public Set<Image> call() throws Exception
      {
        return someServiceThatLoadsImages.load();
      }
    });

try
{
  Set<Image> images = future.get();
  display(images);
} catch (Exception e)
{
  logger.error("Something bad happened", e);
}