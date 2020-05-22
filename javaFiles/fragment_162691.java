public static void main(String[] args) {
        String text = "There are two bread bread.";
        String pattern = "(?<=bread)(.*)(?=bread)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        if (m.find()) {
            System.out.println(m.group());
        } else {
            System.out.println("No sandwich");
        }
  }