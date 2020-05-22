String comment= "service-maintenance,I have been contacted about an airbag recall. When can I book?Make : Nissan\nModel : X-TRAIL\nSeries : T324\nDescription : X-TRAIL Desc\nBodyType : 4X4\n";
    String pattern = "Make : (.*)\nModel : (.*)\nSeries : (.*)\nDescription : (.*)\nBodyType : (.*)\n";

    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(comment);

    if (m.find( )) {
        //System.out.println(m.group(0));
        System.out.println("Make: "+m.group(1));
        System.out.println("Model: "+m.group(2));
        System.out.println("Series: "+m.group(3));
        System.out.println("Description: "+m.group(4));
        System.out.println("BodyType: "+m.group(5));
     }else {
        System.out.println("NO MATCH");
     }