@Configuration
public class Config {

   @Autowired
   private ActorSystem actorSystem;

   @Bean(name = "routerActorRef")
   public ActorRef routerActorRef() { 
      getContext().actorOf(SpringExtProvider.get(actorSystem).props("AnotherActor").withRouter(new RoundRobinPool(100)), "another");
   }

}