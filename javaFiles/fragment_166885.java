public static void main(String[] args) {
    String value = "abc";

    List<Character> characters = new ArrayList<Character>();
    for(char c : value.toCharArray()){
        characters.add(c);
    }

    characters.add(1, 'X');
    System.out.println(characters);

    StringBuilder sb = new StringBuilder();
    for(char c : characters){
        sb.append(c);
    }

    System.out.println(sb.toString());
}