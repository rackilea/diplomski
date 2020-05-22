String input = "[4, 5, 6] + [1, 2, 3]" ;
    Pattern p = Pattern.compile("\\[(.*?)\\]");
    Matcher m = p.matcher(input);
    while (m.find()){
        Set<Integer> S = new TreeSet<>();
        String g = m.group(1);
        Stream.of(g.split(",")).forEach(i -> S.add(Integer.parseInt(i.trim())));    
        System.out.println(S);
    }