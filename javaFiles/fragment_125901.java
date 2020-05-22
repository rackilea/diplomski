public static void main(String[] args) {
    String line = "xx [text other text], [jili u babusi dva veselikh gusya], " +
        "[a granny there was having two gay gooses] zz";

    Matcher matcher = Pattern.compile("\\[([^\\]]+)").matcher(line);

    List<String> tags = new ArrayList<>();

    int pos = -1;
    while (matcher.find(pos+1)){
        pos = matcher.start();
        tags.add(matcher.group(1));
    }

    System.out.println(tags);
}