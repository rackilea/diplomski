private static void teamSearch(String teamName) {

    String subString = teamName;
    String string = "";
    boolean contains = false;

    for (int i = 0; i < clubList.size(); i++){
        string = clubList.get(i).aliases;
        if (string.contains(subString){ 
          contains = true;
          break;
        } 
    }
    System.out.println(contains);
}