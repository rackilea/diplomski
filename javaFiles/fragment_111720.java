String original = "bob Likes Cats";
String[] words = original.split(" ");

//String of the final word.
String finalword = "";

for(String word : words){
    if(Character.isUpperCase(word.charAt(0)){
        //Word has a capital letter
    }else {
        //Add the word.
        finalword += word + " ";
    }
}