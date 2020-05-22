String newsent;
int i; 
//declare these 2 variables
sentence.trim(); //this is important as our program runs on space
for(i=0;i<sentence.length;i++) //to skip the odd words
{
 if(sentence.charAt(i)=" " && sentence.charAt(i+1)!=" ") //enters when a space is encountered after every odd word
 {
 i++;
while(i<sentence.length && sentence.charAt(i)!=" ") //adds the even word to the string newsent letter by letter unless a space is encountered
  {
 newsent=newsent + sentence.charAt(i);
  i++;
   }
   newsent=newsent+" "; //add space at the end of even word added to the newsent
}

}

 System.out.println(newsent.trim()); 
// removes the extra space at the end and prints newsent