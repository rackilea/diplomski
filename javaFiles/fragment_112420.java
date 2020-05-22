String sentence ="This is a simple sentence";
String[] words = sentence.split(" ");

double arrayCount=2;
double firstSentenceLength = Math.ceil(words.length/arrayCount);
String[] sentences = new String[arrayCount];
String first="";
String second="";

for(int i=0; i < words.length; i++){
      if(i<firstSentenceLength){
          first+=words[i]+ " ";
      }else{
          second+=words[i]+ " ";
      }
}
sentences[0]=first;
sentences[1]=second;