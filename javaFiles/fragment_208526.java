private static class NullOnMissingVariableELResolver extends ELResolver
{
    /** {@inhericDoc} */
    @Override
    public Object getValue(ELContext context, Object base, Object property) 
    {
        if (base == null && property != null) 
        {
            String key = property.toString();
            PageContext page = (PageContext) context.getContext(JspContext.class);
            Object result = page.findAttribute(key);

            if (result == null)
            {
                context.setPropertyResolved(true);
            }
        }

        return null;
    }