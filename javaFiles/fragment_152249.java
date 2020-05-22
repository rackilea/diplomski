for (int i = 0; i < input.length(); i ++){ //in your code, this is the inner for and it should be the outer one as it is here

        for(int j = 0; j < Alphabet.length; j++){ //same for this one

            if(input.charAt(i) == Alphabet[j]){

                System.out.print(MorseCode[j] + " || ");

            }//end if 

         }//end inner for
}//end outer for