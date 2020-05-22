register CleanResource* res = ...; call ctor etc..
// inline CleanResource->doSomething()
register int myIndex = res->MyIndex;
res = null;    /// <-----
ResourceImpl* impl = all->get(myInddex);
impl.DoSomething();
// end of inline CleanResource.doSomething()