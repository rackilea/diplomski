public class ServerSerializing<T>
{
   private JAXBContext mJAXBContext = null;
   private final Class<T> type;

   public ServerSerializing(Class<T> type){
     this.type = type;
   }

   public JAXBContext getJAXBContext()
   {
    if(mJAXBContext == null)
        mJAXBContext = JAXBContext.newInstance(type);

    return mJAXBContext;
   }
}