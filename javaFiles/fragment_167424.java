String userLookingGender = ParseUser.getCurrentUser().getString(
        "Looking_Gender");
ParsePush push = new ParsePush();
push.setChannel(userLookingGender);
push.setMessage("Your message");
push.sendInBackground();