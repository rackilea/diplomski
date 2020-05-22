// Get sorted Lists of words and counts from the source Map
    List<String> sortedWordsList = new ArrayList<String>();
    List<Integer> sortedCountsList = new ArrayList<Integer>();              
    for( String word : wordCountMap.keySet() ) 
    {
        Integer wordCount = wordCountMap.get(word);

        int insertIndex=0;
        for( int i=0; i != sortedCountsList.size(); ++i )
        {
            if( wordCount > sortedCountsList.get(i) ) break;
            ++insertIndex;  
        }     
        sortedWordsList.add( insertIndex, word );
        sortedCountsList.add( insertIndex, wordCount );
    }

    // Move top 5 words into a new List
    final int TOP_WORDS_TO_FIND_COUNT = 5;        
    List<String> topWordsList = new ArrayList<String>();
    for( int i=0; i != sortedWordsList.size(); ++i )
    {
        topWordsList.add( i, sortedWordsList.get(i) );
        if( i == TOP_WORDS_TO_FIND_COUNT-1 ) break;
    }     

    // Move top 5 counts into a new List
    List<Integer> topCountsList = new ArrayList<Integer>();
    for( int i=0; i != sortedCountsList.size(); ++i )
    {
        topCountsList.add( i, sortedCountsList.get(i) );
        if( i == TOP_WORDS_TO_FIND_COUNT-1 ) break;
    }