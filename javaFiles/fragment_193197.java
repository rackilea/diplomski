@Named("agentData")
@Scope("application")
public class AgentDataBean implements Serializable,IScheduledComponent {
...
public void doWork() {
  // do database poll
}
 ... 
}