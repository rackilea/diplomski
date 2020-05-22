public class A
{ 
   Func<IMyclass> _ctor;

   public void Init(Func<IMyclass> ctor) 
   {
        _ctor = ctor; 
   }

   public IMyclass CreateMyClass()
   {
        return _ctor();
   }
}