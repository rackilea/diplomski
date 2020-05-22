/**
 * Configure Guava Event Bus to get CDI event and broadcast them to it.
 */
@ApplicationScoped
public class GuavaEventBus {

  private static final Logger LOGGER = LoggerFactory.getLogger(GuavaEventBus.class);

  private static final EventBus eventBus = new EventBus();

  @Produces
  @ApplicationScoped
  private EventBus createGuavaEventBus() {
      return eventBus;
  }

  public void broadcastEveryEvent(@Observes Object event) {
      // There are a lot of bradcasted events, it may be a good solution to filter them.
      LOGGER.debug("Broadcast event: {}", event);
      eventBus.post(event);
  }

  /** Why not registring and unregistring by CDI event? ;) */ 
  public static void register(Object bean) {
      LOGGER.debug("Register bean: {}", bean);
      eventBus.register(bean);
  }

  public static void unregister(Object bean) {
      eventBus.unregister(bean);
  }

}