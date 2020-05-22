public class ListDocumentFactory implements ObjectFactory {

     public Object instantiate(ObjectBinder context, Object value, Type targetType, Class targetClass) {
         if( value instanceof Collection ) {
             return context.bindIntoCollection((Collection)value, new ArrayList(), targetType);
         } else {
             List collection = new ArrayList();
             if( targetType instanceof ParameterizedType ) {
                 ParameterizedType ptype = (ParameterizedType) targetType;
                 collection.add( context.bind(value, ptype.getActualTypeArguments()[0]) );
             } else {
                 collection.add( context.bind( value ) );
                 return collection;
             }
         }
     }
}