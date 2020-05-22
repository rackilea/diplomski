public static void main(String[] args){
    String[] strings = {"String name=\"[COLOR dxvx]yyyy[/COLOR]\"",
            "String name=\"[COLOR dvvx]tttt[/COLOR]\""};

    for(String string : strings) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Matcher matcher = Pattern.compile("(?<=])[^]]+(?=\\[/COLOR)").matcher(string);
        if(matcher.find()){
            System.out.println(matcher.group());
        }

    }
}