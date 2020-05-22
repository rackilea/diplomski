private void postStatusUpdate() {
    Log.d("myLogs", "Test");
    Session session = Session.getActiveSession();
    if (!session.isOpened() && !session.isClosed()) {
        session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
    } else {
        Session.openActiveSession(this, true, statusCallback);
        Log.d("myLogs", "Test 1");
        final String message = "massage to post";
        Request request = Request
                .newStatusUpdateRequest(Session.getActiveSession(), message, new Request.Callback() {
                    @Override
                    public void onCompleted(Response response) {
                        showPublishResult(message, response.getGraphObject(), response.getError());
                    }
                });
        request.executeAsync();
    }
}


private void showPublishResult(String message, GraphObject result, FacebookRequestError error) {
    String title = null;
    String alertMessage = null;
    if (error == null) {
        title = "Success";

        alertMessage = "All is good";
    } else {
        title = "Error";
        alertMessage = error.getErrorMessage();
    }

    new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(alertMessage)
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            })
            .show();
}