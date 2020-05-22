@POST
@Path("/inscription")
@Produces(MediaType.TEXT_HTML)
public Response testClient(String s) {
    ResponseBuilder builder = null;

    try {

        final String xmlString = s;
        final StringReader xmlReader = new StringReader(xmlString);
        final StreamSource xmlSource = new StreamSource(xmlReader);
        final JAXBContext jaxbContext = JAXBContext
                .newInstance(Client.class);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        final Client client = (Client) unmarshaller.unmarshal(xmlSource,
                Client.class).getValue();
        System.out.println("nomCl  : " + client.getNomCl());
        System.out.println("prenomCl  : " + client.getPrenomCl());
        System.out.println("emailCl  : " + client.getEmailCl());
        System.out.println("numTel  : " + client.getNumTel());
        System.out.println("long_  : " + client.getLong_());
        System.out.println("lat  : " + client.getLat());
        System.out.println("LoginCl  : " + client.getLoginCl());
        System.out.println("PasswordCl  : " + client.getPasswordCl());
        System.out.println("adresseCl  : " + client.getAdresseCl());
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("FournisseurWeb");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
        factory.close();
        builder = Response.ok("true");
    } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        builder = Response.ok("false");
        builder.header("Access-Control-Allow-Origin", "*");
        builder.header("Access-Control-Max-Age", "3600");
        builder.header("Access-Control-Allow-Methods", "POST");
        builder.header(
                "Access-Control-Allow-Headers",
                "X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
        return builder.build();
    }
    builder.header("Access-Control-Allow-Origin", "*");
    builder.header("Access-Control-Max-Age", "3600");
    builder.header("Access-Control-Allow-Methods", "POST");
    builder.header(
            "Access-Control-Allow-Headers",
            "X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
    return builder.build();
}