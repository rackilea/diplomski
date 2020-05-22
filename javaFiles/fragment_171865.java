@ServerEndpoint("/SignalingServerEndpoint")
    public class SignalingServerEndpoint {
        //these class variables will be useful for 
        //access to the database and such
        private EntityManagerFactory emf;
        private EntityManager em;
        private EntityTransaction tx;
        private TypedQuery<WebsocketUser> query;
        private WebsocketUser wsu;