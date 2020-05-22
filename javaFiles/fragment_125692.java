@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
                  property  = "forumAnswerId", 
                  scope     = Long.class)
public class ForumAnswer {
}

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
                  property  = "replyId", 
                  scope     = Long.class)
public class ForumAnswerReplay {
}