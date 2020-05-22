//update count for character
        if(charCounts.get(toArray[i]) != null)
        {
            charCounts.put(toArray[i], (charCounts.get(toArray[i]) + 1));
        }
        else
        {
            charCounts.put(toArray[i], 1);
        }