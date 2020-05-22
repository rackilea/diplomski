public static void main(String[] args) {
    String s = "A random statement about anything can go here and it won't change anything.";
    int spaceCount =0;
    int lastIndex=0;
    String[] stringSplitted = new String[10];//assuming the sentence has 100 words or less, you can change the value to Integer.MAX_VALUE instead of 10


    int stringLength=0;//this will give the character count in the string to be split

    for(int i=0;i<s.length();i++){
        if(s.charAt(i)==' '){   //check whether the character is a space, if yes then count the words           
            spaceCount++;// increment the count as you have encountered a word              
        }
        if(spaceCount==10){     //after encountering 10 words split the sentence from lastIndex to the 10th word. For the first time lastIndex would be zero that is starting position of the string        
            stringSplitted[stringLength++] = s.substring(lastIndex, i);
            lastIndex=i;// to get the next part of the sentence, set the last index to 10th word
            spaceCount=0;//set the number of spaces to zero to starting counting the next 10 words
            System.out.println(stringSplitted[0]);
        }
    }
    stringSplitted[stringLength++] = s.substring(lastIndex,s.length()-1);//If the sentence has 14 words, only 10 words would be copied to stringSplitted array, this would copy rest of the 4 words into the string splitted array

    for(int i=0;i<stringSplitted.length;i++){
        if(stringSplitted[i]!=null)
            System.out.println(stringSplitted[i]);//Print the splitted strings here
    }

}