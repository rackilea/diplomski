public static <T> T newArray( Class<T> arrayType, int size )
{
    assert arrayType.isArray();
    @SuppressWarnings( "unchecked" )
    T array = (T)Array.newInstance( arrayType.getComponentType(), size );
    return array;
}