String str ="Billy Joe Bob";

    int targetMatch = 1;
    int offset = 0;
    int position = str.indexOf(' ',offset);
    String result = "";
    result += str.substring(0, 1);
    while(position != -1){
        position++;
        result += str.substring(position,position+1);
        position = str.indexOf(' ', position);
    }
    System.out.println(result);