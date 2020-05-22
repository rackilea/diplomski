String [] arr = {"${US.IDX_CA}", "${UK.IDX_IO}", "${NZ.IDX_BO}", "${JP.IDX_TK}", "${US.IDX_MT}", "more-elements-with-completely-different-patterns-which-is-irrelevant"};
Pattern pattern = Pattern.compile("\\bIDX_(\\w{2})\\b");
for (String s : arr){
     Matcher m = pattern.matcher(s);
      while (m.find()){
        System.out.println(m.group(0)); // Get the whole match
        System.out.println(m.group(1)); // Get the 2 chars after IDX_
      }
}