try {
    URL url = new URL("https://github.com/../../blob/master/update.txt");
    Scanner s = new Scanner(url.openStream());
    String text = s.nextLine();
    s.close();
    text = text.replaceAll("update = ", "");
    Boolean getUpdate = Boolean.parseBoolean(text);
    //do something with the boolean
} catch(Exception ex) {
    ex.printStackTrace();
}