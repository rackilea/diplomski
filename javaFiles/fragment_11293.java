TOKEN_MGR_DECLS:
{
    void CommonTokenAction(Token t)
    {
        MyToken token = (MyToken) t;
        token.offset = input_stream.tokenBegin;
        token.token = t;
    }
}