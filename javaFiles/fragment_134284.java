public  static String convertToString (int value){
    StringBuilder result = new StringBuilder();
    for (int i=1;value/i>0;i *= 10)
        switch( value % (i*10) / i){
            case 0:
                result.append('a');
                break;
            case 1:
                result.append('b');
                break;
            case 2:
                result.append('c');
                break;
            case 3:
                result.append('d');
                break;
            case 4:
                result.append('e');
                break;
            case 5:
                result.append('f');
                break;
            case 6:
                result.append('g');
                break;
            case 7:
                result.append('h');
                break;
            case 8:
                result.append('i');
                break;
            case 9:
                result.append('j');
                break;

        }

    return result.reverse().toString();
}
public  static  int convertToInt(String string){

    int result = 0;
    int j =1;
    for (int i=string.length()-1;i>=0;i--,j *= 10)
        switch(string.charAt(i)){
            case 'b':
                result += 1*j;
                break;
            case 'c':
                result += 2*j;
                break;
            case 'd':
                result += 3*j;
                break;
            case 'e':
                result += 4*j;
                break;
            case 'f':
                result += 5*j;
                break;
            case 'g':
                result += 6*j;
                break;
            case 'h':
                result += 7*j;
                break;
            case 'i':
                result += 8*j;
                break;
            case 'j':
                result += 9*j;
                break;

        }
    return result;
}