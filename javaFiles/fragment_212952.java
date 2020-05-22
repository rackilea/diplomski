String str = "['2', '0', '1', '4', '-', '0', '5', '-', '3', '1', ' ', '1', '6', ':', '5', '8', '\\r', '\\n', 'I', 'D', ':', '1', '1', '7', '\\r', '\\n', 'L', 'o', 'w', '\\r', '\\n', '\\r', '\\n', '\\r', '\\n']";
        Pattern p = Pattern.compile("((,\\s*)?'([A-Za-z])'((,\\s*)?'([A-Za-z])')+)((,\\s*)?'\\\\r)+");
        Matcher m = p.matcher(str);
        while(m.find())
        {
            String newString = m.group(1).replaceAll("[,' ]", "");
            System.out.println(newString);
        }