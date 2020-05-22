String regex = "(?<=\\?q=)([^(]*)\\(([\\d.]*)";
        String s = "htt://maps.google.com/maps?q=52.258301,+-7.111900+(192.168.159.1Country:Ireland,City:Waterford-by htt://www.javaquery.com)&iwloc=A&hl=en";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.println(m.group(2));
            System.out.println(m.group(1));
        }