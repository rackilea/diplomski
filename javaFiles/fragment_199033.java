public static void main(String[] args) {

    String line = "'7858','1194','FSP,FRB,FWF,FBVS,FRRC','15'\n" +
            "'7859','1194','FIRM','21'";

    Pattern r = Pattern.compile("'(.*?)','(.*?)','(.*?)','(.*?)'");

    String[] lines = line.split("\n");
    for (String l : lines) {

        System.out.println("Line : " + l);

        Matcher m = r.matcher(l);
        if (m.find()) {
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
            System.out.println("Found value: " + m.group(4));
        } else {
            System.out.println("NO MATCH");
        }
    }

}