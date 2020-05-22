class Main {

    public static void main(String as[]) {
        String str = "Lorem Ipsum is simply dummy text of the printing and "
            + "typesetting industry. Lorem Ipsum has been the industry's "
            + "standard dummy text ever since the 1500s";

        String setA = "Lorem, text, dummy";
        String setB = "Ipsum, printing, industry";
        String setC = "Lorem, text, dummy,Ipsum, printing, industry";
        Main m = new Main();

        if (str.matches(m.getPattern(setA))) {
            //Do something
        } else if (str.matches(m.getPattern(setB))) {
            //Do something
        } else if (str.matches(m.getPattern(setC))) {
            //Do something
        }

    }

   //The important method
   private String getPattern(String words) {
       StringBuilder pattern = new StringBuilder();
       System.out.println(Arrays.toString(words.split(",\\s*")));
       Arrays.asList(words.split(",\\s*"))
               .stream()
               .map(t -> "(?=.*\\b" + t + "\\b).*")
               .forEach(pattern::append);
       return "(?i)" + pattern.toString();
   }
}