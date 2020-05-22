@Controller
class Listener {

    @MessageMapping("/string")
    public void handle(String in) {
        System.out.println("STOMP Received: " + in);
    }

    @JmsListener(destination = "so50614472")
    public void listen(String in) {
        System.out.println("JMS Received: " + in);
    }

}