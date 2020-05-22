String[] cmntIds = request.getParameterValue("cmntId"); //This store all the cmntId that are checked in the previous checkbox.
String newComment = request.getParameterValue("newComment");
String userId = request.getParameterValue("userId"); //This can be in a session

//Some function you may need
deleteComment(cmntIds); //Execute a query to delete comment using the cmntIds
inserNewComment(newComment, userId); //Execute a query to add the new comment using newComment and userId if there is a comment attached.