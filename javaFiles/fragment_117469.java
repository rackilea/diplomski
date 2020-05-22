@SpringBootApplication
public class Application {

public static void main(String[] args) {
    ConfigurableApplicationContext context = new  SpringApplicationBuilder(Application.class).headless(false).run(args);

    EventQueue.invokeLater(() -> {
        // this is your JFrame
        AppPrincipalFrame appFrame = context.getBean(AppPrincipalFrame.class);
        appFrame.setVisible(true);
    });