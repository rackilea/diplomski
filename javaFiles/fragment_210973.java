InputStream in = null;
OutputStream out = null;

try
{
    in = ...
    out = ...

    final byte[] buf = new byte[ 1024 ];

    for( int count = in.read( buf ); count != -1; count = in.read( buf ) )
    {
        out.write( buf, 0, count );
    }
}
finally
{
    if( in != null )
    {
        in.close();
    }

    if( out != null )
    {
        out.close();
    }
}