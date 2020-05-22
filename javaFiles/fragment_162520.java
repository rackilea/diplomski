@Provider
@Named("userProviderParamInjector")
public class UserProviderParam implements StringReaderProvider<Users> {

    @Context
    HttpServletRequest request;

    public StringReader<Users> getStringReader(Class<?> type, Type type1, Annotation[] antns) {
        if(type.equals(Users.class) {
           return null;
        }

        String attributeValue = null;
        for(Annotation a : antns) {
            if((a.getClass().getSimpleName()).equals("AttributeParam")){
               attributeValue = (String)AnnotationUtils.getValue(a);
            }
        }

        return new StringReader<Users>(){
            public Users fromString(String string) {
                // Use the value of the *Param or ignore it and use the attributeValue of our custom annotation.
                return request.getAttribute(attributeValue);
            }

        };

    }

}