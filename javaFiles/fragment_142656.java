String json = "/Date(1391802454790-0700)/";
    json=json.replace("/Date(", "").replace("-0700)/", "");
    long time = Long.parseLong(json);
    Date d= new Date(time);
    System.out.println("Dateeee---->"+d);
    System.out.println(new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(d));