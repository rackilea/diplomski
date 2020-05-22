@Controller
public class AdminController {

@Bean
public SystemWebSocketHandler systemWebSocketHandler() {
    return new SystemWebSocketHandler();
}