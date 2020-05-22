public int compareTo(Word other)
    {
        int difference = word.length() - other.word.length();
        if(difference == 0){
            return word.compareToIgnoreCase(other.word);
        else{
            return difference;    
        }

    }