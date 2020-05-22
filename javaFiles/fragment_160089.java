for(char c: initialNumber.toLowerCase().toCharArray()){
    switch(c){
    case '0':                                         result+="0";
    case '1':                                         result+="1";break;
    case '2': case 'a': case 'b': case 'c':           result+="2";break;
    case '3': case 'd': case 'e': case 'f':           result+="3";break;
    case '4': case 'g': case 'h': case 'i':           result+="4";break;
    case '5': case 'j': case 'k': case 'l':           result+="5";break;
    case '6': case 'm': case 'n': case 'o':           result+="6";break;
    case '7': case 'p': case 'q': case 'r': case 's': result+="7";break;
    case '8': case 't': case 'u': case 'v':           result+="8";break; 
    case '9': case 'w': case 'x': case 'y': case 'z': result+="9";break;
    }
}