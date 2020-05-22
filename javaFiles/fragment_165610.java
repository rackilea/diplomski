class CommentResponse extends Comment {
   private long commentId;
   private Timestamp entryDateTime;
   // etc
}

class AjaxResponse{
 private CommentResponse commentResponse;
 private String responseCode;
 //other stuff
}