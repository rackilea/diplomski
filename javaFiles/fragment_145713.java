ind i = 0; 
     while(ind < sentence.length){
        ch = sentence.charAt(ind);
        if(ch == '.') break;
        if(ch >= 'a' && ch <= 'z')
            lowerLetter++;
        else if(ch >= 'A' && ch <= 'Z')
            upperLetter++;
        else if(ch >= '0' && ch <= '9')
            digits++;
        else
            punctuation++;
        ind++;
     }