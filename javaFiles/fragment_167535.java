RequestContext context = RequestContext.getCurrentInstance();

if (condition)
{
    context.addCallbackParam("someVariable", true);
}
else
{
    context.addCallbackParam("someVariable", false);
}