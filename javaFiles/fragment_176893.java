String s = "||HelpDesk||IT Staff||IT Staff||Admin||Audit||HelpDesk||";
 Set<String> set = new LinkedHashSet<>(Arrays.asList(s.split(Pattern.quote("||"))));
 String noDup = "||";
 for(String st : set) {
     if(st.isEmpty()) continue;
     noDup += st+"||";
 }