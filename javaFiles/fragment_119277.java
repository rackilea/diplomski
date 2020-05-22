List<String> list = Arrays.asList("$.Colors[*].name","$.Colors[*].Color[*].name","$.Colors[?(@.type == 'Primary')].Color[*].name");
Pattern p = Pattern.compile("(.*?)(\\[[^\\[\\]]*\\])(.*)");

list.forEach(x -> {
    Matcher m = p.matcher(x);
    if (m.matches()) {
        System.out.println("For string: " + x);
        System.out.println("Before: "+ m.group(1));
        System.out.println("Separator: "+ m.group(2));
        System.out.println("After: "+ m.group(3));
        System.out.println();
    }
});