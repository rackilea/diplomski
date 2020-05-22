for(int i=0;i<input.length();i++)
    {
        if(strings.isVowel(i) &&(i==0 || strings.endWord(i-1))){ 
            beg = i;
            for(int j = i; j < input.length();j++) //look for end of word
            {
                if(strings.endWord(j)) //word has ended
                {
                    i = j; //start from end of last word
                    strings.findWord(beg, j);         
                    break; //word done, end word search
                }
            }
        }
    }