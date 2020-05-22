public MockTypes getMockTypeByName(String adaptor, String step)
{
    for(MockTypes m : MockTypes.values())
    {
        if(m.getAdaptor().equals(adaptor) && 
           m.getStep().equals(step)) return m;
    }
    return null;
}