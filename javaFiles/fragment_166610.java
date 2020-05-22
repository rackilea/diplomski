@SpringBootApplication
@ComponentScan
public class Application {

public static void main(String[] args) {

    SpringApplication.run(Application.class, args);

}


@Bean
@Primary
public PriorityQueue<WorkOrder> priorityQueue() {

    PriorityQueue<WorkOrder> queue = new PriorityQueue<WorkOrder>(10,
            Comparator.comparing(WorkOrder::getRank).thenComparing(
                    WorkOrder::getDatetime));

    return queue;
}
}