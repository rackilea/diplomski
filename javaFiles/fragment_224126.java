abstract class MyModel extends AbstractReadOnlyModel{
    @Override
    public String toString()
    {
        if(getObject()==null)return "";
        return getObject().toString();
    }
}