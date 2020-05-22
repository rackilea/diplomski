String s  = "lat: 56.894205 long: 008.528896 speed: 000.0 24/02/13 21:21   bat:F signal:F  imei:12345678901";
Pattern p = Pattern.compile("lat: (?<lat>\\d+\\.\\d+) long: (?<lng>\\d+\\.\\d+).*imei:(?<imei>\\d+)");
Matcher m = p.matcher(s);
while (m.find()) {
    String lat  = m.group("lat");
    String lng  = m.group("lng");
    String imei = m.group("imei");
    System.out.println(lat);  //=> "56.894205"
    System.out.println(lng);  //=> "008.528896"
    System.out.println(imei); //=> "12345678901"
}