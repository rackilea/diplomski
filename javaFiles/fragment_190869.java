// main program
String str = "Count 225989 the 20124 integer 20124 122 words"
String[] splitted = str.split(" ");
for (String s : splitted){
    if(isNumber(s))
         System.out.println(s);
}

public boolean isNumber(String s){
    for (char c : s.toCharArray()){
        if(c<48 || c>57){
            return false;
        }
    }
    return true;
}