public class MyAppModule {
    public PropertyConduitSource decoratePropertyConduitSource(final PropertyConduitSource old) {
       return new PropertyConduitSource() {
          public PropertyConduit create(Class rootType, String expression) { 
             PropertyConduit conduit = old.create(rootType, expression);

             // you cound also check for conduit.getAnnotation(AllowNull.class) 
             // and then annotate your bean properties for a more granular approach
             if (Boolean.class.equals(conduit.getPropertyType()) {
                return new TernaryPropertyConduit(conduit);
             }
             return conduit;
          }
       }
    }
}

public class TernaryPropertyConduit implements PropertyConduit {
   private PropertyConduit delegate;

   public getPropertyType() { return Ternary.class };

   public set(Object instance, Object value) {
      delegate.set(instance, ((Ternary) value).asBoolean());
   }

   public get(Object) {
      Boolean bValue = (Boolean) delegate.get(instance);
      return Ternary.valueOf(instance);
   }
}