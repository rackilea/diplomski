public class AnotherUser extends Entity {}

public class RequestParserImpl implements RequestParser {
    <T extends Entity> Message<T> parseRequest(String json) {
         return new Message<AnotherUser>();
    }
}