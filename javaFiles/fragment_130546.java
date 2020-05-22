public Query where(String selection, String operator, Object value) 
{
    ArrayList<Object> list = new ArrayList<Object>();
    list.add( value );
    return where(selection, operator, list);
}