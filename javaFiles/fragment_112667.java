private void doStuff() {
    int answer1 = 2;
    int answer2 = 1;

    String s = "{hidSection=if(((Q4a.NAOK==\"5\" && Q4b.NAOK==\"7\")|| (Q4a.NAOK==\"6\" && Q4b.NAOK==\"6\") || (Q4a.NAOK==\"6\" && Q4b.NAOK==\"7\")|| \n" +
            "            (Q4a.NAOK==\"7\" && Q4b.NAOK==\"5\")|| (Q4a.NAOK==\"7\" && Q4b.NAOK==\"6\") || (Q4a.NAOK==\"7\" && Q4b.NAOK==\"7\")|| \n" +
            "            (Q4a.NAOK==\"8\" && Q4b.NAOK==\"7\")|| (Q4a.NAOK==\"12\" && Q4b.NAOK==\"6\")|| (Q4a.NAOK==\"12\" && Q4b.NAOK==\"7\"))\n" +
            "    ,1,if(((Q4a.NAOK==\"4\" && Q4b.NAOK==\"6\") || (Q4a.NAOK==\"4\" && Q4b.NAOK==\"7\") || (Q4a.NAOK==\"5\" && Q4b.NAOK==\"5\")||\n" +
            "            (Q4a.NAOK==\"5\" && Q4b.NAOK==\"6\")|| (Q4a.NAOK==\"7\" && Q4b.NAOK==\"3\") || (Q4a.NAOK==\"6\" && Q4b.NAOK==\"5\")|| \n" +
            "            (Q4a.NAOK==\"7\" && Q4b.NAOK==\"4\")|| (Q4a.NAOK==\"8\" && Q4b.NAOK==\"6\")|| (Q4a.NAOK==\"10\" && Q4b.NAOK==\"7\")|| \n" +
            "            (Q4a.NAOK==\"11\" && Q4b.NAOK==\"6\")|| (Q4a.NAOK==\"11\" && Q4b.NAOK==\"7\")|| (Q4a.NAOK==\"12\" && Q4b.NAOK==\"5\"))\n" +
            "    ,2,if(((Q4a.NAOK==\"4\" && Q4b.NAOK==\"5\") || (Q4a.NAOK==\"5\" && Q4b.NAOK==\"4\")|| (Q4a.NAOK==\"6\" && Q4b.NAOK==\"4\")|| \n" +
            "            (Q4a.NAOK==\"7\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"7\" && Q4b.NAOK==\"2\")|| (Q4a.NAOK==\"8\" && Q4b.NAOK==\"5\")|| \n" +
            "            (Q4a.NAOK==\"9\" && Q4b.NAOK==\"6\")|| (Q4a.NAOK==\"9\" && Q4b.NAOK==\"7\")|| (Q4a.NAOK==\"10\" && Q4b.NAOK==\"6\")|| \n" +
            "            (Q4a.NAOK==\"11\" && Q4b.NAOK==\"5\")|| (Q4a.NAOK==\"12\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"12\" && Q4b.NAOK==\"2\")|| \n" +
            "            (Q4a.NAOK==\"12\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"12\" && Q4b.NAOK==\"4\"))\n" +
            "    ,3,if(((Q4a.NAOK==\"2\" && Q4b.NAOK==\"6\") || (Q4a.NAOK==\"2\" && Q4b.NAOK==\"7\")|| (Q4a.NAOK==\"3\" && Q4b.NAOK==\"6\")|| \n" +
            "            (Q4a.NAOK==\"3\" && Q4b.NAOK==\"7\")|| (Q4a.NAOK==\"4\" && Q4b.NAOK==\"4\")|| (Q4a.NAOK==\"5\" && Q4b.NAOK==\"3\")|| \n" +
            "            (Q4a.NAOK==\"6\" && Q4b.NAOK==\"2\")|| (Q4a.NAOK==\"6\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"8\" && Q4b.NAOK==\"4\")|| \n" +
            "            (Q4a.NAOK==\"9\" && Q4b.NAOK==\"5\")|| (Q4a.NAOK==\"10\" && Q4b.NAOK==\"5\")|| (Q4a.NAOK==\"11\" && Q4b.NAOK==\"4\"))\n" +
            "    ,4,if(((Q4a.NAOK==\"2\" && Q4b.NAOK==\"4\") || (Q4a.NAOK==\"2\" && Q4b.NAOK==\"5\")|| (Q4a.NAOK==\"3\" && Q4b.NAOK==\"4\")||                (Q4a.NAOK==\"3\" && Q4b.NAOK==\"5\")|| \n" +
            "            (Q4a.NAOK==\"4\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"5\" && Q4b.NAOK==\"2\")|| (Q4a.NAOK==\"6\" && Q4b.NAOK==\"1\")|| \n" +
            "            (Q4a.NAOK==\"9\" && Q4b.NAOK==\"4\")|| (Q4a.NAOK==\"10\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"10\" && Q4b.NAOK==\"4\")|| \n" +
            "            (Q4a.NAOK==\"11\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"11\" && Q4b.NAOK==\"2\")|| (Q4a.NAOK==\"11\" && Q4b.NAOK==\"3\"))\n" +
            "    ,5,if(((Q4a.NAOK==\"1\" && Q4b.NAOK==\"4\") || (Q4a.NAOK==\"1\" && Q4b.NAOK==\"5\")|| (Q4a.NAOK==\"1\" && Q4b.NAOK==\"6\")|| \n" +
            "            (Q4a.NAOK==\"1\" && Q4b.NAOK==\"7\")|| (Q4a.NAOK==\"2\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"3\" && Q4b.NAOK==\"2\")|| \n" +
            "            (Q4a.NAOK==\"3\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"4\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"4\" && Q4b.NAOK==\"2\")|| \n" +
            "            (Q4a.NAOK==\"5\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"8\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"8\" && Q4b.NAOK==\"2\")|| \n" +
            "            (Q4a.NAOK==\"8\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"9\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"9\" && Q4b.NAOK==\"2\")||                \n" +
            "            (Q4a.NAOK==\"9\" && Q4b.NAOK==\"3\")|| (Q4a.NAOK==\"10\" && Q4b.NAOK==\"1\")|| (Q4a.NAOK==\"10\" && Q4b.NAOK==\"2\"))\n" +
            "    ,6,if(((Q4a.NAOK==\"1\" && Q4b.NAOK==\"3\") || (Q4a.NAOK==\"2\" && Q4b.NAOK==\"2\"))\n" +
            "    ,7,if(((Q4a.NAOK==\"1\" && Q4b.NAOK==\"1\") || (Q4a.NAOK==\"1\" && Q4b.NAOK==\"2\") || (Q4a.NAOK==\"2\" && Q4b.NAOK==\"1\") || \n" +
            "            (Q4a.NAOK==\"3\" && Q4b.NAOK==\"1\"))\n" +
            "    ,8,\"\"))))))))}";

    String answer = getAnswer(answer1, answer2, s);
    Log.d("xxx", "answer:" + answer);
}

private String getAnswer(int answer1, int answer2, String s) {
    //remove spaces 2 or more length and replace to 1
    s = s.replaceAll("\n", "");
    s = s.replaceAll("\\s+", " ");

    ArrayList<String> states = new ArrayList<String>();

    Pattern p = Pattern.compile("if\\({3}.*?\\,\\d+");
    Matcher m = p.matcher(s);
    while (m.find()) {
        states.add(m.group());
    }

    String stateFormat = "Q4a.NAOK==\"%d\" && Q4b.NAOK==\"%d\"";
    String stateFormatted = String.format(stateFormat, answer1, answer2);

    for (int i = 0; i < states.size(); i++) {
        if (states.get(i).contains(stateFormatted)) {
            String[] items = states.get(i).split(",");
            if (items.length > 1) {
                return items[1].trim();
            }
        }
    }

    return null;//or null or integer -1
}