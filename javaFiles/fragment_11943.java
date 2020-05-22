String str = "{Code=1;NumServices=3;Service1=World Weather Online;Link1=http://www.worldweatheronline.com/;Service2=Open Weather Map;Link2=http://openweathermap.org/;Service3=Weather;Link3=http://www.weather.gov/;}";
Pattern ptrn = Pattern.compile("Code=([^;]*);NumServices=([^;]*);|Service(\\d+)=([^;]*);Link\\d+=([^;]*);");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    if (matcher.group(1) != null) {
       System.out.println("Code: " + matcher.group(1));
       System.out.println("NumServices: " + matcher.group(2));
    }
    else if (matcher.group(1) == null && matcher.group(2) == null) {
       System.out.println("Service #: " + matcher.group(3));
       System.out.println("Service Name: " + matcher.group(4));
       System.out.println("Link: " + matcher.group(5));
    }
}