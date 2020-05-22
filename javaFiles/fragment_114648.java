public final class MyUserType implements SQLData
{
    public String userId;
    public String userName;

    public MyUserType(){}

    public MyUserType( final String userId, final String userName )
    {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String getSQLTypeName() throws SQLException
    {
        return "one_user_type";
    }

    @Override
    public void readSQL( final SQLInput stream, final String typeName ) throws SQLException
    {
        userId = stream.readString();
        userName = stream.readString();
    }

    @Override
    public void writeSQL( final SQLOutput stream ) throws SQLException
    {
        stream.writeString( userId );
        stream.writeString( userName );
    }
}