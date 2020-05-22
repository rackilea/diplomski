IntBuffer get(int[] array, int index) 
{
    return IntBuffer.wrap( array, index, 1 ).slice();
}

get( array, 5 ).put( 42 );