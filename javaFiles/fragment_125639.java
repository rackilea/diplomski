Map<String, String> deviceToForumMap = new HashMap<String, String>();
deviceToForumMap.put("RWFORUM", "http://rootzwiki.com/forum/");
deviceToForumMap.put("TORO", "362-cdma-galaxy-nexus-developer-forum");

...

String forum = deviceToForumMap.get(android.os.Build.DEVICE.toUpperCase());