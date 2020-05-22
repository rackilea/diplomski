new LoadableDetachableModel<List<Hit>>()
{
    protected Object load()
    {
        return getResults(currentQuery);
    }
}