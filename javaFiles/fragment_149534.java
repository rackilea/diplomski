String url = request.getRequestURL().toString();
if(url.endsWith("signin"))
{
// Don't look for authorization header, and let the filter pass without any checks
}
else
{
// DO YOUR NORMAL AUTHORIZATION RELATED STUFF HERE
}