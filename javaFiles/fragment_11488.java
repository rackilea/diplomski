for( int i = 0; i < story.size(); i++){
    String s = story.get(i);

    if(s.contains("ADJEKTIV."))
    {
        //replace the value with a new one.
        s = randomAdjective(adjectivesFilename) + ". ");
        story.set(i, s);
        /* OR shorter
        story.set(i, randomAdjective(adjectivesFilename) + ". ");
        */
    }

    ...
}