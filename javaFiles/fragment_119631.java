String str = "rtt min/avg/max/mdev = 10.876/13.344/17.155/2.736 ms";

    String[] strings = str.split(" "); // split string on spaces, 5 new strings
    str = strings[3]; // select the 4th of these strings

    strings = str.split("/"); // split again, this time on "/"

    double min = Double.parseDouble(strings[0]);
    double avg = Double.parseDouble(strings[1]);
    double max = Double.parseDouble(strings[2]);
    double deviation = Double.parseDouble(strings[3]);