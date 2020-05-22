private class ForcableContentTypeWrapper extends HttpServletResponseWrapper
{
    public ForcableContentTypeWrapper(HttpServletResponse response)
    {
        super(response);
    }

    @Override
    public void setContentType(String type)
    {
    }
    public void forceContentType(String type)
    {
        super.setContentType(type);
    }
}