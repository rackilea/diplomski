public class TrimSpace {

static String trimAll(String str, int startIndex, int endIndex){
    if(str.charAt(startIndex)!=' ' && str.charAt(endIndex)!=' '){
        return str.substring(startIndex, endIndex+1);
    }
    else if(str.charAt(startIndex)==' ' && str.charAt(endIndex)==' '){
        return trimAll(str, startIndex+1, endIndex-1);
    }
    else if(str.charAt(startIndex)==' ' && str.charAt(endIndex)!=' '){
        return trimAll(str, startIndex+1, endIndex);
    }
    else{
        return trimAll(str, startIndex, endIndex-1);
    }
}

public static void main(String[] args) {

    String str = "   hello   ";
    String result = trimAll(str, 0, str.length()-1);
    System.out.println(result);
    //to count extra spaces you just need to get the length difference 
    int extraSpaces = str.length() - result.length();
    System.out.println(extraSpaces);
}