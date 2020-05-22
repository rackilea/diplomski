PrettyTime p = new PrettyTime();
    System.out.println(p.format(new Date()));
    //prints: “right now”

    PrettyTime t = new PrettyTime(new Date(3155692597470L * 3L));
    t.format(new Date(0));
    //3 centuries ago