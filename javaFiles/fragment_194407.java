Map<String, String> dict = new HashMap<String, String>() {{
    put("wrd", "word");
    put("congrats", "congratulations");
    put("oswm", "awesome");
    put("awsum", "awesome");
}};


String input = "Here's an awsum example wrd, congrats!";

StringBuffer result = new StringBuffer();

Pattern p = Pattern.compile("\\w+");
Matcher m = p.matcher(input);

while (m.find()) {
    String toInsert = m.group();
    if (dict.containsKey(toInsert))
        toInsert = dict.get(toInsert);
    m.appendReplacement(result, toInsert);

}

m.appendTail(result);

System.out.println(result);