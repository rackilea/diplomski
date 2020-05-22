public class UserProvider extends PerRequestTypeInjectableProvider<AttributeParam, Users>{

    public UserProvider(){
        super(Users.class);
    }

    @Context
    HttpServletRequest request;

    @Override
    public Injectable<Users> getInjectable(ComponentContext cc, AttributeParam a) {

        String attributeValue = AnnotationUtils.getValue(a);

        return new Injectable<Users>(){

            public Users getValue() {
                System.out.println("Called"); //This should be called for each request
                return request.getAttribute(attributeValue);
            }

        };

    }

}