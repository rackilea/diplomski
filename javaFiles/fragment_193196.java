@Named("scheduler")
@Component
public class SchedulerComponent {

private List<IScheduledComponent> components;

public SchedulerComponent() {
    this.components = new ArrayList<IScheduledComponent>();
}


public void register(IScheduledComponent component){
    this.components.add(component);
}


@Scheduled(fixedRate = 5000)
public void doAllWork() {
    try {
        for(IScheduledComponent component : this.components){
            component.doWork();
        }

        System.out.println("SchedulerComponent.doAllWork()");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}