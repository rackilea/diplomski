public class SubclassA extends SuperclassA
{
   @Override
   public void method(SuperclassB b){
       if (!(b instanceof SubclassB)) {
           // throw some exception
       }
       SubclassB sb = (SubclassB) b;
       ...
   }
}