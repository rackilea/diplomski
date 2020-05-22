public class A
{ 
   IMyClassProvider _provider;

   public void Init(IMyClassProvider provider) 
   {
        _provider = provider; 
   }

   public IMyclass CreateMyClass()
   {
        return _provider.Create();
   }
}