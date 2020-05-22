String comment= "service-maintenance,I have been contacted about an airbag recall. When can I book?Make : Nissan\nModel : X-TRAIL\nSeries : T324\nDescription : X-TRAIL Desc\nBodyType : 4X4\n";
    String pattern = "(Make|Model|Series|Description|BodyType) : (.*)\n";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(comment);

    while (m.find()) {
        //System.out.println(m.group(0));
        System.out.println(m.group(1) + "=" + m.group(2));
     }