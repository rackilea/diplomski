public static int uppercase(String str){
    int cnt = 0;

    String[] words = str.split(" ");

    for(int i = 0; i < words.length; i++){
        if(Character.isUpperCase(words[i].charAt(0)))
            cnt++;
    }

    return cnt;
}