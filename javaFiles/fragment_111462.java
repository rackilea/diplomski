ParseObject flytagdata = new ParseObject("stack");
    flytagdata.put("Tag", sb.toString());
    flytagdata.put("Username", Constant.FB_USERNAME);
    flytagdata.put("UserFBId", Constant.FB_USERID);
    flytagdata.put("User", ParseUser.getCurrentUser());//FIXED THIS LINE
flytagdata.saveInBackground();