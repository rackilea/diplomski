static final class TabInfo{
   public final String tag;
   public final String clss;
   public Bundle args;

   TabInfo(String _tag, Class<?> _class, Bundle _args) {
       tag = _tag;
       clss = _class.getName();
       args = _args;
   }
 }