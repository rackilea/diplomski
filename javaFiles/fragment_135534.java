public static void split(String tree){

    String[] lines = tree.split("\n");
    List<List<String>> lists = new ArrayList<List<String>>(); 
    for(String line : lines){
        List<String> temp = new ArrayList<String>();
        while(line.indexOf("|") != -1){
            temp.add("|");
            line = line.replaceFirst("\\|", "");
        }
        temp.add(line.trim());
        lists.add(temp);
    }

    for(int i = 0; i < 3; i++){
        lists.remove(0);
    }
    for(int i = 0; i < 4; i++){
        lists.remove(lists.size()-1);
    }
    List<String> substitutes = new ArrayList<String>();

    for(List<String> list : lists){
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).contains(":") && !list.get(i).equals("|") && !substitutes.contains(list.get(i))){
                substitutes.add(list.get(i));
            }
        }
    }
    for(List<String> list : lists){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("|")){
                list.set(i, substitutes.get(i));
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    for(List<String> list : lists){
        String line = "";
        for(String s : list){
            line = line+" "+s;
        }
        if(line.endsWith(")")){
            sb.append(line+"\n");
        }
    }
    System.out.println(sb.toString());
}