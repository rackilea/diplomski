for (int i=0; i< line.length(); i++){
   convert(line.charAt(i));
}


private static int convert(char c){
    int answer;
    switch(c){
        case 'A': 
        case 'B': 
        case 'C':
            answer = 2;
            break;
        case 'D':
        case 'E':
        case 'F':
            answer = 3;
            break;
        ....
    }
    return answer;
}