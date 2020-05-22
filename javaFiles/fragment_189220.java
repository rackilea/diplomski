String advertiserUrl = "http://111.111.11.111:1111/api/ppppp/2f5d1a31-878a-438b-a03b-e9f51076074a/adver‌​tisers/9";
//                           | preceded by "/"
//                           |     | any non-"/" character, reluctantly quantified
//                           |     |     | followed by "/advertisers"
Pattern p = Pattern.compile("(?<=/)[^/]+?(?=/adver‌​tisers)");
Matcher m = p.matcher(advertiserUrl);
if (m.find()) {
    System.out.println(m.group());
}