public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("Yes");
    list.add("No");
    list.add("Maybe");
    list.add("Probably");
    list.add("Never");

    String niceOutput = addOr(list);
    System.out.println("Choose from following options: " + niceOutput);
}   

public static String addOr(List<String> list){
    String orText = "";
    int count = 0;
    for(String text : list){
        count++;
        orText += '\'' + text + '\'';
        if (count != list.size()){
            orText += " or ";
        }
    }
    return orText;        
}