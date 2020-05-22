if (toArray[i] >= 'a' && toArray[i] <= 'z') 
        {
            if (toArray[i] - 'a' <= 13) toArray[i] = (char) ('z' - (toArray[i] - 'a'));
            else toArray[i] = (char) ('a' + ('z' - toArray[i]));
        }

        //does the upper case characters
        else if(toArray[i] >= 'A' && toArray[i] <= 'Z')
        {
            if (toArray[i] - 'A' <= 13) toArray[i] = (char) ('Z' - (toArray[i] - 'A'));
            else toArray[i] = (char) ('A' + ('Z' - toArray[i]));
        }
        //if the characters are non alphatbetic 
        else 
        {
            toArray[i] = toArray[i];
        }
    }