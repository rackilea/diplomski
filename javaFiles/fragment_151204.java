if (character >='a' && character <='z'){

     newMsg+=character;

   }else if(character > 'z') { // space will be shifted once again

      newMsg+=(char)((char)(c-(26-shift)));
   }