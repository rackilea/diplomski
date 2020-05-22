@Projection(name = "summary", types = Message.class)
public class MessageSummary { 
    @Value("#{target.getClass().getSimpleName()}")
    String getType();    
}

@Projection(name = "summary", types = TextMessage.class)
public class TextMessageSummary extends MessageSummary { ... }

@Projection(name = "summary", types = TodoMessage.class)
public class TodoMessageSummary extends MessageSummary {
     Boolean getIsDone();
}