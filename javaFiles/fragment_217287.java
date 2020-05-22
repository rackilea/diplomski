public static void main(String[] args) {
    String mandar="mandar\\jitendra\\saye";
    String[] words=mandar.split(Pattern.quote("\\"));
    for(int a=0;a<words.length;a++)
    {
        System.out.println(words[a]);
    }
}