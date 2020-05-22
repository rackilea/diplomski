List<Object> get(Object[] array, int index) 
{
    return Arrays.asList( array ).subList( offset, offset + 1 );
}

get( array, 5 ).set( 0, new Object() );