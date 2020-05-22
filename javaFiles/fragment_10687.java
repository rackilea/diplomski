private <T> queryBean(Function<IFrontControllerRemote,T> transform) {
    Properties props = new Properties();
    props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");

    try {
        InitialContext ctx = new InitialContext(props);
        String ejbUrl = "ejb:ShopManagmentEAR/ShopManagmentEJB//FrontController!"+IFrontControllerRemote.class.getName();

        IFrontControllerRemote bean = (IFrontControllerRemote) ctx.lookup(ejbUrl);

        return transform.apply(bean);

    } catch (NamingException e) {
        System.out.println("error");
        e.printStackTrace();
    }
    return null;
}