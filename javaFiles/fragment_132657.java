public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[\\w.]+@[\\w.]+");
        Matcher matcher = pattern.matcher("\"a.b@c.d\" <a.b@c.d>|\"Michal pichal (michal.pichal@g.d)\" <michal.pichal@g.d>|Melisko Pan <melisko.pan@domena.sk>\r\n");
        while(matcher.find()){
            String group = matcher.group();
            System.out.println("group="+group);
        }