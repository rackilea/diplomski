JSONObject jObj = new JSONObject(jData);
ArrayList<Comment> cList = new ArrayList<Comment>();
servResponse = Integer.parseInt(jObj.getString("returnCode").trim());
JSONArray objarr = jObj.getJSONArray("result");
for(int i = 0;i< objarr.length();i++){
    JSONObject jCment = objarr.getJSONObject(i);
    if(servResponse == 1){
       JSONArray jCommentArr = jCment.getJSONArray("commentList");
          for(int j=0; j<jCommentArr.length(); j++)
          {
              Comment comment = new Comment();
              JSONObject jComment = jCommentArr.getJSONObject(j);

              comment.commenterId = Integer.parseInt(jComment.getString("account_id").trim());
              comment.commenterName = jComment.getString("name").trim();
              comment.commentMessage = jComment.getString("comment").trim();
              comment.postDate = jComment.getString("created_on").trim();

              cList.add(comment);
          }
    }
}