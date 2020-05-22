public static void bitStringToText (String binText){

//no need to do this if you are not modifying the contents of binText
//String bs = binText; 

int from =0;
int to = 1;
int size = binText.length();
String temp = "";

while(to <= size ){
    temp = binText.substring(from, to);
    if (main.newMapDecoding.containsKey(temp)){
    main.decodedTxt += main.newMapDecoding.get(temp);
    from =to;
    to = from +1;
    } else {
        to = to + 1;
    }
  }
}