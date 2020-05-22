String text =
        "Wait a minute... what?!? Oh yeah! This is awesome!!";

    for (String part : text.split("(?<=[.?!]) ")) {
        System.out.println(part);
    }