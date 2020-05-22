@Provider 
public class JAXBContextResolver implements ContextResolver<JAXBContext> { 

    private JAXBContext context; 
    private Class[] types = { UserBasic.class, UserBasicInformation.class }; 

    public JAXBContextResolver() throws Exception { 
         this.context = 
       new JSONJAXBContext( 
         JSONConfiguration.natural().build(), types); 
     } 

    public JAXBContext getContext(Class<?> objectType) { 
        /* 
        for (Class type : types) { 
            if (type == objectType) { 
                return context; 
            } 
        } // There should be some kind of exception for the wrong type.
        */ 
        return context; 
    } 
} 

//My resource method: 

    @GET 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
    public JAXBElement<UserBasic> get(@QueryParam("userName") String userName) { 
        ObjectFactory ob = new ObjectFactory(); 
        UserDTO dto = getUserService().getByUsername(userName); 
        if(dto==null) throw new NotFoundException(); 
        UserBasic ub = new UserBasic(); 
        ub.setId(dto.getId()); 
        ub.setEmailAddress(dto.getEmailAddress()); 
        ub.setName(dto.getName()); 
        ub.setPhoneNumber(dto.getPhoneNumber()); 
        return ob.createUserBasic(ub); 
    } 

//My Guice configuration module: 

public class MyServletModule extends ServletModule { 


    public static Module[] getRequiredModules() { 
        return new Module[] { 
                new MyServletModule(), 
                new ServiceModule(), 
                new CaptchaModule() 
         }; 
    } 


    @Override 
    protected void configureServlets() { 
        bind(UserHttpResource.class); 
        bind(JAXBContextResolver.class);
        serve("/*").with(GuiceContainer.class); 
    } 
}