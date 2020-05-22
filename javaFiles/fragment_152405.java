RequiredService s = Lookup.getDefault().lookup(RequiredService.class);
if (s != null)
{
    s.doSomething(); // In this case the responsibility of reliability lies on the side of who implemented this service.
}
else
{
    // Now it's up to you to keep it reliable and perhaps let the user know that something went not as expected.
}