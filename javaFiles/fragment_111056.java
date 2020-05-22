private static String a = "war";
private static String b = "Its awesome being a programmer".replace(" ","");
private static String answer = "waaarrrIbeeeeggimmmnoopsst";

public static void main(String[] args) {
    List<String> characters = new ArrayList<String>(b.length());
    for (int i=0;i<b.length();i++){
        characters.add(String.valueOf(b.charAt(i)));
    }
    Collections.sort(characters,new CompareIt(a));
    String sortedString = listToString(characters);
    System.out.println(sortedString);
    System.out.println(answer);
    System.out.println(answer.equals(sortedString));
}
private static String listToString(List<String> listOfStrings){
    StringBuilder builder = new StringBuilder();
    for (String str : listOfStrings){
        builder.append(str);
    }
    return builder.toString();
}
private static class CompareIt implements Comparator<String>{

    private final String source;

    public CompareIt(String source) {
        super();
        this.source = source;
    }

    public int compare(String o1, String o2) {
        int i1 = source.indexOf(o1);
        int i2 = source.indexOf(o2);
        if (i1==-1 && i2!=-1){
            return 1;
        } else if (i1!=-1 && i2==-1){
            return -1;
        } else if (i1!=-1 && i2!=-1){
            return i1 > i2 ? 1:-1;
        } else {
            return o1.compareTo(o2);
        }
    }

}