String str = obj.getnameString();
char firstVowel;    

for(int i = 0; i < str.length(); i++){
    if(str.charAt(i) == "a" || str.charAt(i) == "o" || ...... || str.charAt(i) == "U"){ //pretty sure theres an easier solution for that
        firstVowel = str.charAt(i);
        break;
    }
}