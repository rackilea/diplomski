comments = new ParseQuery < ParseObject > ("CommentItem");
comments.setLimit(99);
comments.whereEqualTo("parentUser", feedUserName);
comments.whereEqualTo("parentFeed", feedItem);

// show progres dialog 
final ProgressDialog myDialog = ProgressDialog.show(this, "Loading...","Loading Results...", true);

comments.findInBackground(new FindCallback < ParseObject > () {@
  Override
  public void done(List < ParseObject > mobjects, ParseException e) {

    myDialog.dismiss();  // remove progress dialog on finish
    if (e == null) {

      for (ParseObject object: objects) {




      }


    }


  }
});