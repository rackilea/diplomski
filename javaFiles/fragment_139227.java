@RestController
public class TestController {
    @RequestMapping("/")
    @PreAuthorize("#oauth2.hasScope('nothing')")
    public Message home(OAuth2Authentication principal) {
        return new Message("Hello World");
    }

    class Message {
        private String id = UUID.randomUUID().toString();
        private String content;

        Message() {}

        public Message(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }
}