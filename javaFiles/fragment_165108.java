static <ChildPage extends ParentPage> ChildPage NavigateToPage(Class<ChildPage> cls, String url)
{
   // do something with the url
   //
   ChildPage destinationPage = cls.newInstance();
   return destinationPage;
}