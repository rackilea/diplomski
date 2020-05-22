public void doRepetitions(List<Object> original)
{
    for( int i=0; i<10; i++ )
    {
        List<Object> working = new ArrayList<Object>( original );
        doStuffWithList(working);
    }
}