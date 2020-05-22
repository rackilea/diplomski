String input = "https://www.google.com/?gws_rd=ssl\n" +
"http://www.cs.jhu.edu/news-events/news-articles/\n" +
"maps.google.com\n" +
"http://www.cnn.com/WORLD/?hpt=sitenav\n" +
"http://www.cnn.com/JUSTICE/?hpt=sitenav\n" +
"http://www.cs.jhu.edu/course-info/\n" +
"http://e-catalog.jhu.edu/departments-program-requirements-and-courses/engineering/computer-science/\n" +
"http://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html\n" +
"http://mexico.cnn.com/?hpt=ed_Mexico\n" +
"cnn.com";
Pattern regex = Pattern.compile("[^.\\n]+\\.(?:com|edu)");
Matcher matcher = regex.matcher(input);
while(matcher.find()){
            System.out.println(matcher.group(0));
   }