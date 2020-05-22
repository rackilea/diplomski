getdata() throws Exception
{
    setup();
    try { 
        readUrls();
    } finally {
        closeConnection();
    }
}