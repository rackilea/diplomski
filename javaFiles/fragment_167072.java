String url = "https://mysite.com/providers/271/pins/4997/edit";
//                           | preceded by "pins/"
//                           |         | 1 or more digits 
//                           |         |   | followed by "/edit"
Pattern p = Pattern.compile("(?<=pins/)\\d+(?=/edit)");
Matcher m = p.matcher(url);
if (m.find()) {
    //                   | whole group will only capture "\\d+"
    System.out.println(m.group());
}