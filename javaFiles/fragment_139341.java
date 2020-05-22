String allow_dev_server = String.valueOf(responseData.get("allow_dev"));
boolean b = allow_dev_server.equals("true");
int allow_dev = b ? 1 : 0; // true == 1
Profile profile;
profile = GsonHolder.getGSONInstance().fromJson(responseData.getAsJsonObject("profile"), Profile.class);
profile.allow_dev = allow_dev;