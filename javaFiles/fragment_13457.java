@Aspect
@Component
@Profile("mail")
public class OrderNotificationAspect {
    private final MailService mailService;

    public OrderNotificationAspect(MailService mailService) {
        this.mailService = mailService;
    }

    @AfterReturning("execution(* com.example.MyRestController.createOrders(..))")
    public void sendNotification() {
        mailService.send("Order notification", "New orders", "1@mail.com");
    }
}