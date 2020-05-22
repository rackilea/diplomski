private class EndlessLocationAdapter extends EndlessAdapter
{
  public EndlessLocationAdapter(LocationAdapter adapter)
    {
    super(adapter);
    }

  @Override
  protected boolean cacheInBackground() throws Exception
    {
    //Fetch more data
    }
//Other methods such as getPendingView(), appendCachedData()
}