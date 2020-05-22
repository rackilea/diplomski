IConverter:
fromType: Object.class
toType: Object.class

public Object convert(Object fromObject)
{
    if(fromObject instanceof EMPTYEnum)
    {
        return null;
    }
    return fromObject;
}