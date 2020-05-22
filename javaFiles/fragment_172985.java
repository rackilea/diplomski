public static void main(String[] args) throws FileNotFoundException {
        String test = "1591 : Dummy 1592 : Dummy 1593 : Dummy 1594 : Dummy 1595 : Dummy 1596 : Dummy";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(test);
        while (m.find()) {
            System.out.println("Found a " + m.group() + ".");
        }


        p = Pattern.compile("[a-zA-Z]+");
        m = p.matcher(test);
        while (m.find()) {
            System.out.println("Found a " + m.group() + ".");
        }

 }