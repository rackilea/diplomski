if (JsonUtils.isNetworkAvailable(Activity_Feedback.this))
{
    String name = "";
    String email ="";
    String message = "";
    try {
        name = URLEncoder.encode(strName, "UTF-8");
        email = URLEncoder.encode(strEmail, "UTF-8");
        message = URLEncoder.encode(strMsg, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    new MyTaskFeedBack().execute(Constant.FEEDBACK_URL+name+"&email="+email+"&message="+message);
}