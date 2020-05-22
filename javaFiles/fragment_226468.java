public static void main(String[] args) {
        String line = "9.99\t8.29\tAB=0.0;CD=0.0;EF=0.0;GH=0.0;LI=0.0;JK=0.0";
        String[] labels = new String[]{"AB", "EF", "LI", "JK"};
        Pattern p = Pattern.compile("\\b[a-zA-Z]+=");
        Matcher m = p.matcher(line);
        while (m.find()) {
            String groupName = m.group(0).substring(0,m.group(0).length()-1);
            if (Arrays.asList(labels).contains(groupName)) {
                continue;
            } else {
                System.out.println(groupName);
            }
        }
    }