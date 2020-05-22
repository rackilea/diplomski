MyResult results = new MultiCatchAndStore().generateResults(new Bar());
try
{
  results.reThrowException();
} catch(RuntimeException | ExecutionException | InterruptedException ex)
{
  // handle, of course, you could also have separate catch clauses here
}