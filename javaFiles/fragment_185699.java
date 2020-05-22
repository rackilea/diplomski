@ApplicationScoped
public class LoggerProducer {

   private final ConcurrentMap<String, Logger> loggers = new ConcurrentHashMap<>();

   @Produces
   public Logger getProducer(InjectionPoint ip) {
      String key = getKeyFromIp(ip);
      loggers.putIfAbsent(key, Logger.getLogger(key));
      return loggers.get(key);
   }

   private String getKeyFromIp(InjectionPoint ip) {
     return ip.getMember().getDeclaringClass().getCanonicalName();
  }
}