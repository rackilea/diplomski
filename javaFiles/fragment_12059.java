public abstract class Like {
    public Long id;

    public String foo;
}

public class PostLike extends Like {

    public String post;
}


public class TopicLike extends Like {

    public String topic;
}