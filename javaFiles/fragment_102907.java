public static String[] synToWords(String syn){
    String[] words = syn.split("\\t");
    return new String[] {words[0], words[1]};
}

String[] words = synToWords(synFR.getLine(3));
System.out.println(words[0] +" " + words[1]);