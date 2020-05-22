String text = "(info1) something-uninteresting [info2, info22] s.u. [info3] s.u. (info4, info5, info6)";
    Pattern p = Pattern.compile(" ?[\\w-.]+");

    Matcher m = p.matcher(text);
    while (m.find()) {
        System.out.println(m.group());
    }