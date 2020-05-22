builder.setNeutralButton("DELETE POST", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        try {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");

            query.whereEqualTo("ObjectID", selectedPost.getObjectId());

            query.findInBackground(new FindCallback<ParseObject>() {
                public void done(List<ParseObject> postList, ParseException e) {
                    if (e == null) {
                        for (ParseObject post : postList) {
                            post.deleteInBackground();
                        }
                    }
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("post", "error " + e);
        }
        dialog.dismiss();
    }
});