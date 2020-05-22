Pattern userIdPattern = Pattern.compile("^userId:\\s*\"(\\d+)\";.*$"); // will be the userId number
 Pattern objPattern = Pattern.compile(".*(obj\\s*:\\s*\{[^\}]+\}).*"); //will be the JSON object inside
 Matcher userIdMatcher = userIdPattern.matcher("userId: \"929290\"; name: \"Donnie Darko\"; obj : {field1: \"field\"; field2: \"field2\"} phone: \"666-6666\";");
 if(userIdMatcher.find()){
     System.out.println("userId : " + .group(1));
 }
 Matcher objPatternMatcher = objPattern.matcher("userId: \"929290\"; name: \"Donnie Darko\"; obj : {field1: \"field\"; field2: \"field2\"} phone: \"666-6666\";");
 if(objPatternMatcher.find()){
     System.out.println(objPatternMatcher.group(1));
 }